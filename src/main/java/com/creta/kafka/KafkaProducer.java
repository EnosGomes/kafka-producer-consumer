package com.creta.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaProducer {

    public static final String TOPIC = "enos";

    private final KafkaTemplate<String, TaskStatus> kafkaTemplate;

    public void sendFlightEvent(TaskStatus event){
        kafkaTemplate.send(TOPIC,  event);
        log.info("Producer produced the message {}", event);
    }
}
