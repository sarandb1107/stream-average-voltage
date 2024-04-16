package org.example;

import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import io.confluent.kafka.serializers.KafkaAvroDeserializerConfig;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.protocol.types.Field;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.*;
import org.apache.kafka.streams.processor.TimestampExtractor;

import java.sql.Time;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static io.confluent.kafka.serializers.AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG;
import static java.util.Optional.ofNullable;

public class StreamsApplication {
    public static void main(String[] args) {
        Properties config = new Properties();
        config.put(StreamsConfig.APPLICATION_ID_CONFIG, "hourly-voltage-consumption");
        config.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        config.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        config.put(SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8081");

        SpecificAvroSerde<PowerRecord> DateTimeSerde = getDateTimeSerde(config);
        SpecificAvroSerde<VoltageAggregate> VoltageAvgSerde = getAvgVoltage(config);

        config.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, DateTimeSerde.getClass());

        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class);
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        StreamsBuilder builder = new StreamsBuilder();

//        TimestampExtractor eventDateTimeExtractor = new StreamsApplication.EventTimestampExtractor();
        config.put(StreamsConfig.DEFAULT_TIMESTAMP_EXTRACTOR_CLASS_CONFIG, EventTimestampExtractor.class.getName());
        KStream<String, PowerRecord> InputStream = builder.stream("voltage_datas", Consumed.with(Serdes.String(), DateTimeSerde)
                .withTimestampExtractor(new EventTimestampExtractor()));

//        KStream<String, PowerRecord> timestampsStream = InputStream.map((key, value) -> {
//                    String timestampKey = value.get("Date")+ " " + value.get("Time");
//                    return KeyValue.pair(timestampKey, value);
//                });

        KGroupedStream<String, Float> groupedStream = InputStream.map((key, value) -> {
          String timestampKey = value.getDate() + " "  + value.getTime();
          return new KeyValue<>(timestampKey, value);
        }).filter((key, value) -> value.getVoltage() != 0.0)
                .selectKey((key, value) -> "All")
                .mapValues(value -> (Float) value.getVoltage())
                .groupByKey(Grouped.with(Serdes.String(), Serdes.Float()));

        TimeWindows windows = TimeWindows.of(Duration.ofHours(1));

        TimeWindowedKStream<String, Float> windowedKStream = groupedStream.windowedBy(windows);

        /*To check the data in streams */
//        InputStream.foreach((key, value) -> {
//            System.out.println("Received - key: " + key + ", Value: " + value);
//        });

        KTable<Windowed<String>, VoltageAggregate> avgsourceStream = windowedKStream
//                .filter((key, value) -> value.get("Voltage") != null)
//                .selectKey((key, value) -> "All")
//                .mapValues(value -> (Float) value.get("Voltage"))
//                .groupByKey(Grouped.with(Serdes.String(), Serdes.Float()))

//                .windowedBy(TimeWindows.of(Duration.ofHours(1)))
                .aggregate(
                        () -> new VoltageAggregate(0, 0.0),
                        (key, value, aggregate) -> {
                            aggregate.setCount(aggregate.getCount()+1);
                            aggregate.setSum(aggregate.getSum() + value.doubleValue());
                            return aggregate;
                        },
                        Materialized.with(Serdes.String(), VoltageAvgSerde)
                );
        final KTable<Windowed<String>, Double> averageVoltage = avgsourceStream.mapValues(value -> value.getSum() / value.getCount(), Materialized.with(null, Serdes.Double()));
//        averageVoltage.toStream().foreach((key, value) -> {
//            Instant start = key.window().startTime();
////            Instant windowStart = Instant.ofEpochSecond(startTime*1000);
//            Instant end = key.window().endTime();
////            Instant windwoEnd = Instant.ofEpochSecond(endTime * 1000);
//
//            System.out.println(  key.window().start() );
//            System.out.println("windowStart : " + start + " windowEnd : " + end + " Average : " + value);
//        });

        KStream<String, Double> AvgStream = averageVoltage
                .toStream()
                .map((key, value) -> {
                    String windowTime = key.window().startTime() + "-" + key.window().endTime();
                    String keywithTime = "Date & Time - " + key.key() + " - " + windowTime;
                    return new KeyValue<>(keywithTime, value);
                });

        AvgStream.to("voltage-average-per-hour", Produced.with(Serdes.String(), Serdes.Double()));

        KafkaStreams streams = new KafkaStreams(builder.build(), config);
        streams.cleanUp();
        streams.start();
    }

    public static SpecificAvroSerde<PowerRecord> getDateTimeSerde(Properties envProps) {
        SpecificAvroSerde<PowerRecord> serde = new SpecificAvroSerde<>();
        serde.configure(getSerdeConfig(envProps), false);
        return serde;
    }
    public static SpecificAvroSerde<VoltageAggregate> getAvgVoltage(Properties envProps) {
        SpecificAvroSerde<VoltageAggregate> serde = new SpecificAvroSerde<>();
        serde.configure(getSerdeConfig(envProps), false);
        return serde;
    }

    public static Map<String, String> getSerdeConfig(Properties props) {
        final HashMap<String, String> map = new HashMap<>();
        final String schemaURL = props.getProperty(SCHEMA_REGISTRY_URL_CONFIG);
        map.put(SCHEMA_REGISTRY_URL_CONFIG, ofNullable(schemaURL).orElse(""));
        return map;
    }
}
