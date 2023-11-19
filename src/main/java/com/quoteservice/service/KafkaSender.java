package com.quoteservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class KafkaSender {
    private final KafkaTemplate<String, Map<String, Object>> kafkaTemplate;

    @Autowired
    KafkaSender(KafkaTemplate<String, Map<String, Object>> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Map<String, Object> message, String topicName) {
        System.out.println(message);
        kafkaTemplate.send(topicName, message);
    }
}
