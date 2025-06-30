package com.example.spring_kafka_producer.service;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
@Service
public class MessageConsumer {
    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "my-group")
    public void listen(ConsumerRecord<String, String> record) {
        System.out.println("Received message: " + record.value());
        System.out.println("Partition: " + record.partition() + ", Offset: " + record.offset());
    }
}