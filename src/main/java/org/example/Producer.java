package org.example;

import io.confluent.kafka.serializers.KafkaAvroSerializer;
import org.apache.avro.Schema;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static java.lang.Float.parseFloat;

public class Producer {

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class.getName());
        props.put("schema.registry.url", "http://localhost:8081");

        KafkaProducer<String, PowerRecord> producer = new KafkaProducer<>(props);
        try(BufferedReader reader = new BufferedReader(new FileReader("/home/administrator/Downloads/household_power_consumption.txt"))) {


            reader.readLine();

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");

                if (parts.length != 9) {
                    // Handle the case where the line doesn't have the expected number of elements
//                    System.out.println("Invalid data line: " + line);
                    continue;
                }

                PowerRecord record = PowerRecord.newBuilder()
                        .setDate(parts[0])
                        .setTime(parts[1])
                        .setGlobalActivePower(ParseFloat(parts[2]))
                        .setGlobalReactivePower(ParseFloat(parts[3]))
                        .setVoltage(ParseFloat(parts[4]))
                        .setGlobalIntensity(ParseFloat(parts[5]))
                        .setSubMetering1(ParseFloat(parts[6]))
                        .setSubMetering2(ParseFloat(parts[7]))
                        .setSubMetering3(ParseFloat(parts[8]))
                        .build();
                ProducerRecord<String, PowerRecord> data = new ProducerRecord<>("voltage_datas", record);
                producer.send(data);
                System.out.println("Record Finally ! " + record.toString());
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static Float ParseFloat(String value) throws NumberFormatException {
        if ("?".equals(value.trim())) {
            return null;
        }
        return Float.parseFloat(value);
    }
}
