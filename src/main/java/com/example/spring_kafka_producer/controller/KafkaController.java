package com.example.spring_kafka_producer.controller;

import com.example.spring_kafka_producer.service.MessageProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/kafka")
public class KafkaController {
    private final MessageProducer messageProducer;
    public KafkaController(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }
    @PostMapping("/publish")
    public ResponseEntity<String> publishMessage(@RequestParam String message) {
        messageProducer.sendMessage(message);
        return ResponseEntity.ok("Message published to Kafka: " + message);
    }
}