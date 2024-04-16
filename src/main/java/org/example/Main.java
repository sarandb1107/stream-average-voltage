//package org.example;
//
//import org.apache.avro.Schema;
//import org.apache.avro.generic.GenericData;
//import org.apache.avro.generic.GenericRecord;
//import org.apache.kafka.clients.producer.KafkaProducer;
//import org.apache.kafka.clients.producer.Producer;
//import org.apache.kafka.clients.producer.ProducerConfig;
//import org.apache.kafka.clients.producer.ProducerRecord;
//import org.apache.kafka.common.serialization.StringSerializer;
//import java.io.BufferedReader;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.nio.charset.StandardCharsets;
//import java.util.Properties;
//
//public class Main {
//    private static final String AVRO_SCHEMA_JSON = "{"
//            + "\"type\":\"record\","
//            + "\"name\":\"PowerRecord\","
//            + "\"fields\":["
//            + "    {\"name\":\"Date\",\"type\":\"string\"},"
//            + "    {\"name\":\"Time\",\"type\":\"string\"},"
//            + "    {\"name\":\"Global_active_power\",\"type\":\"float\"},"
//            + "    {\"name\":\"Global_reactive_power\",\"type\":\"float\"},"
//            + "    {\"name\":\"Voltage\",\"type\":\"float\"},"
//            + "    {\"name\":\"Global_intensity\",\"type\":\"float\"},"
//            + "    {\"name\":\"Sub_metering_1\",\"type\":\"float\"},"
//            + "    {\"name\":\"Sub_metering_2\",\"type\":\"float\"},"
//            + "    {\"name\":\"Sub_metering_3\",\"type\":\"float\"}"
//            + "]}";
//
//    public static void main(String[] args) throws IOException {
//        // Read the Avro schema
//        Schema.Parser parser = new Schema.Parser();
//        Schema avroSchema = parser.parse(AVRO_SCHEMA_JSON);
//
//        // Configure Kafka Producer
//        Properties props = new Properties();
//        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
//        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, io.confluent.kafka.serializers.KafkaAvroSerializer.class.getName());
//        props.put("schema.registry.url", "http://localhost:8081");
//
//        // Create Kafka Producer
//        Producer<String, GenericRecord> producer = new KafkaProducer<>(props);
//
//        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("/home/administrator/Downloads/household_power_consumption.txt"), StandardCharsets.UTF_8))) {
//            // Skip the header line
//            br.readLine();
//            String line;
//            while ((line = br.readLine()) != null) {
//                GenericRecord avroRecord = createAvroRecordFromLine(line, avroSchema);
//                if (avroRecord != null) {
//                    ProducerRecord<String, GenericRecord> record = new ProducerRecord<>("hourly_voltage", avroRecord);
//                    producer.send(record);
//                    System.out.println("Record produced: " + avroRecord.toString());
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            producer.close();
//        }
//    }
//
//    private static GenericRecord createAvroRecordFromLine(String line, Schema avroSchema) {
//        String[] parts = line.split(";");
//        if (parts.length != 9) {
//            // Handle the case where the line doesn't have the expected number of elements
//            System.err.println("Invalid data line: " + line);
//            return null; // Return null to indicate an issue with the current line
//        }
//        GenericRecord record = new GenericData.Record(avroSchema);
//        try {
//            record.put("Date", parts[0]); // Pass the original date string
//            record.put("Time", parts[1]);
//            record.put("Global_active_power", parseFloat(parts[2]));
//            record.put("Global_reactive_power", parseFloat(parts[3]));
//            record.put("Voltage", parseFloat(parts[4]));
//            record.put("Global_intensity", parseFloat(parts[5]));
//            record.put("Sub_metering_1", parseFloat(parts[6]));
//            record.put("Sub_metering_2", parseFloat(parts[7]));
//            record.put("Sub_metering_3", parseFloat(parts[8]));
//        } catch (NumberFormatException e) {
//            // Handle the exception or log it, depending on your needs
//            System.err.println("Error parsing values in line: " + line);
//            e.printStackTrace();
//            return null; // Return null to indicate an issue with the current line
//        }
//        return record;
//    }
//
//    private static Float parseFloat(String value) throws NumberFormatException {
//        if ("?".equals(value.trim())) {
//            // Handle the case where the value is "?" (or any other non-numeric indicator)
//            // You might want to return a default value or throw an exception, depending on your requirements
//            return null; // or throw new NumberFormatException("Invalid numeric format");
//        }
//        return Float.parseFloat(value);
//    }
//}