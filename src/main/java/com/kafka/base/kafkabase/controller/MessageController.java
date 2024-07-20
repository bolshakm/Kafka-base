package com.kafka.base.kafkabase.controller;

import com.kafka.base.kafkabase.dto.RequestData;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/message")
public class MessageController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public MessageController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public ResponseEntity<Object> publish(@RequestBody RequestData requestData){
        kafkaTemplate.send("kafka-base", requestData.getMessage());

        return ResponseEntity.ok().build();

    }
}
