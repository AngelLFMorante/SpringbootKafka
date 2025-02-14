package org.afernandez.example.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    @KafkaListener(topics = "example-topic", groupId = "group_id")
    public void listen(String message) {
        System.out.println("Mensaje recibido: " + message);
    }
}
