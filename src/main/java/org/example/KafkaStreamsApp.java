//package org.example;
//
//import io.confluent.kafka.streams.serdes.avro.*;
//
//import java.time.LocalDateTime;
//import java.time.ZoneId;
//import java.time.format.DateTimeFormatter;
//import java.util.*;
//
//import org.apache.avro.generic.GenericRecord;
//import org.apache.kafka.clients.consumer.ConsumerConfig;
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.apache.kafka.common.serialization.Serde;
//import org.apache.kafka.common.serialization.Serdes;
//import org.apache.kafka.streams.KafkaStreams;
//import org.apache.kafka.streams.kstream.*;
//import org.apache.kafka.streams.KeyValue;
//import org.apache.kafka.streams.StreamsBuilder;
//import org.apache.kafka.streams.StreamsConfig;
//import org.apache.kafka.streams.processor.TimestampExtractor;
//
//import java.time.Duration;
//
//import static io.confluent.kafka.serializers.AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG;
//import static java.util.Optional.ofNullable;
//
//public class KafkaStreamsApp {
//
//
////    public static class VoltageAggregate {
////        private double sum;
////        private int count;
////
////        public VoltageAggregate(double sum, int count) {
////            this.sum = sum;
////            this.count = count;
////        }
////
////        public double getSum(){
////            return sum;
////        }
////
////        public void setSum(double sum){
////            this.sum = sum;
////        }
////
////        public int getCount(){
////            return count;
////        }
////
////        public void setCount(int count) {
////            this.count = count;
////        }
////    }
//    public static class EventTimestampExtractor implements TimestampExtractor {
//        @Override
//        public long extract(final ConsumerRecord<Object, Object> record, final long previousTimestamp) {
//            final GenericRecord event = (GenericRecord) record.value();
//            final String eventDate =  event.get("Date").toString();
//            final String eventTime =  event.get("Time").toString();
//            final String eventDateTime = eventDate + " " + eventTime;
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy HH:mm:ss");
//            LocalDateTime dateTime = LocalDateTime.parse(eventDateTime, formatter);
//
//            final long timestamp = dateTime.atZone(ZoneId.of("UTC")).toEpochSecond();
//
////            log.trace("Event ({}) yielded timestamp: {}", event.getEventId(), timestamp);
//
//            return timestamp;
//        }
//    }
//
//
//    public static void main(String[] args) {
//        Properties config = new Properties();
////        VoltageAggregate voltageData = new VoltageAggregate(0,0);
//        config.put(StreamsConfig.APPLICATION_ID_CONFIG, "hourly-voltage-consumption");
//        config.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//        config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
////        config.put(StreamsConfig.DEFAULT_TIMESTAMP_EXTRACTOR_CLASS_CONFIG, EventTimestampExtractor.class);
//        config.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
////        config.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, GenericAvroSerde.class);
//        config.put(SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8081");
//
////
////        // Create an instance of VoltageAggregate using its builder
////        VoltageAggregate.Builder builder = VoltageAggregate.newBuilder();
////
////        // Set values using the builder's setter methods
////        VoltageAggregate aggregate = builder.setSum(0.0).setCount(0).build();
////        SpecificRecordBuilderBase<VoltageAggregate> builder = new SpecificRecordBuilderBase<>(VoltageAggregate.getClassSchema());
//
////        Schema avroSchema = new Schema.Parser().parse(Main.AVRO_SCHEMA_JSON);
//
//
//        final Map<String, String> serdeConfig = (Map)config;
//
////        final Serde<GenericRecord> keyGenericAvroSerde = new GenericAvroSerde();
////        keyGenericAvroSerde.configure(serdeConfig, true); // `true` for record keys
//        final Serde<org.example.GenericRecord> valueGenericAvroSerde = new SpecificAvroSerde<>();
//        valueGenericAvroSerde.configure(serdeConfig, false); // `false` for record values
//        config.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, valueGenericAvroSerde.getClass().getName());
//
//        StreamsBuilder builder = new StreamsBuilder();
//
//
//        TimestampExtractor eventDateTimeExtractor = new EventTimestampExtractor();
//        KStream<String, org.example.GenericRecord> sourceStream = builder.stream("hourly_voltage", Consumed.with(Serdes.String(), valueGenericAvroSerde).withTimestampExtractor(eventDateTimeExtractor));
////        sourceStream.peek((key, value) -> System.out.println("value: " + value));
//        KStream<String, org.example.GenericRecord> timestampsStream = sourceStream.map((key, value) -> {
//            String timestampKey = value.get("Date") + " " + value.get("Time");
//            return KeyValue.pair(timestampKey, value);
//        });
//
//        SpecificAvroSerde<VoltageAggregate> AverageConsumption = getAvgVoltage(config);
//
//        KTable<Windowed<String>, VoltageAggregate> avgsourceStream = timestampsStream
//                .filter((key, value) -> value.get("Voltage") != null)
//                .selectKey((key, value) -> "All")
//                .mapValues(value -> (Float) value.get("Voltage"))
//                .groupByKey(Grouped.with(Serdes.String(), Serdes.Float()))
//
//                .windowedBy(TimeWindows.of(Duration.ofHours(1)))
//                .aggregate(
//                        () -> new VoltageAggregate(0, 0.0),
//                        (key, value, aggregate) -> {
////                            double voltage = Double.parseDouble(value.get("Voltage").toString());
//                            aggregate.setCount(aggregate.getCount()+1);
//                            aggregate.setSum(aggregate.getSum() + value.doubleValue());
//                            return aggregate;
//                        },
//                          Materialized.with(Serdes.String(), AverageConsumption)
////                        Materialized.as("AVG_Voltage_Store")
////                        Materialized.<String, VoltageAggregate, KeyValueStore<Bytes, byte[]>>as("AverageVoltage"));
//                );
////                suppress(Suppressed.untilWindowCloses(Suppressed.BufferConfig.unbounded()));
//
//        avgsourceStream.toStream()
//                .peek((key, value) -> System.out.println("Hourly consumption for hour " + key.window().startTime() + " - " + key.window().endTime() + ": " + value.getSum() / value.getCount()));
////                .map((key, value) -> KeyValue.pair(key.key(), value.getSum() / value.getCount()))
////                .to("output_topic", Produced.with(Serdes.String(), Serdes.Double()));
//
////        avgsourceStream.to("hourly-voltage-consumption-Store-repartition", Produced.with(WindowedSerdes.timeWindowedSerdeFrom(String.class),valueGenericAvroSerde));
//
//        KafkaStreams streams = new KafkaStreams(builder.build(), config);
//        streams.start();
//        Runtime.getRuntime().addShutdownHook(new Thread(streams::close));
//    }
//    public static SpecificAvroSerde<VoltageAggregate> getAvgVoltage(Properties envProps) {
//        SpecificAvroSerde<VoltageAggregate> serde = new SpecificAvroSerde<>();
//        serde.configure(getSerdeConfig(envProps), false);
//        return serde;
//    }
//
//    public static Map<String, String> getSerdeConfig(Properties props) {
//        final HashMap<String, String> map = new HashMap<>();
//        final String schemaURL = props.getProperty(SCHEMA_REGISTRY_URL_CONFIG);
//        map.put(SCHEMA_REGISTRY_URL_CONFIG, ofNullable(schemaURL).orElse(""));
//        return map;
//    }
//
//}
