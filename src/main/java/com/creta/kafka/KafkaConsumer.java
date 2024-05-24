package com.creta.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaConsumer {

    @KafkaListener(topics = "enos", groupId = "group")
    public void flightEventConsumer(TaskStatus taskStatus) {
        log.info("Consumer consume Kafka message -> {}", taskStatus);
    }
}

