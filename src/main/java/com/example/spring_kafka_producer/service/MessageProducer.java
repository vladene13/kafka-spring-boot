package com.example.spring_kafka_producer.service;


import org.springframework.beans.factory.annotation.Value;

import org.springframework.kafka.core.KafkaTemplate;

import org.springframework.stereotype.Service;

@Service

public class MessageProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${spring.kafka.topic.name}")

    private String topicName;

    public MessageProducer(KafkaTemplate<String, String> kafkaTemplate) {

        this.kafkaTemplate = kafkaTemplate;

    }

    public void sendMessage(String message) {

        kafkaTemplate.send(topicName, message);

        System.out.println("Sent message: " + message);

    }

}
