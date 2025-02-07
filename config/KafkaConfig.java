package com.example.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Configuration
class KafkaTopicConfig {
    @Bean
    public NewTopic topic() {
        return new NewTopic("example-topic", 1, (short) 1);
    }
}
