package org.example;

import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.streams.processor.TimestampExtractor;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class EventTimestampExtractor implements TimestampExtractor {
    @Override
    public long extract(ConsumerRecord<Object, Object> record, long previousTimestamp) {
        final PowerRecord event = (PowerRecord) record.value();
        final String eventDate =  event.getDate().toString();
        final String eventTime =  event.getTime().toString();
        final String eventDateTime = eventDate + " " + eventTime;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(eventDateTime, formatter);

        final long timestamp =  dateTime.atZone(ZoneId.of("UTC")).toInstant().toEpochMilli();
//        System.out.println(timestamp);
//        final long timestamp = dateTime.to
//            log.write("Event ({}) yielded timestamp: {}", timestamp);
        return timestamp;
    }
}
