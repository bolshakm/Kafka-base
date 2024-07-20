package com.kafka.base.kafkabase.listeners;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {
    @KafkaListener(topics = "kafka-base", groupId = "kafka-base_groupId")
    public void listener(String data) {
        System.out.println("Listener received: " + data);
    }
}
