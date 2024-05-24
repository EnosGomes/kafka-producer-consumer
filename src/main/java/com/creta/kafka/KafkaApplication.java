package com.creta.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class KafkaApplication implements CommandLineRunner {

    @Autowired
    KafkaTemplate kafkaTemplate;

    @Autowired
    KafkaProperties kafkaProperties;

    @Override
    public void run(String... args) throws Exception {

        kafkaTemplate.send("enos", 0, "taskId", new TaskStatus("taskId", "task1", 50.0f, TaskStatus.Status.RUNNING));
        kafkaTemplate.send("enos", 0, "taskId", new TaskStatus("taskId", "task2", 100.0f, TaskStatus.Status.FINISHED));

    }

    public static void main(String[] args) {
        SpringApplication.run(KafkaApplication.class, args);
    }

}
