package com.creta.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendMessageController {

    @Autowired
    KafkaProducer kafkaProducer;

    @PostMapping
    public void sendMessage(@RequestParam String nome) {
        TaskStatus taskStatus = new TaskStatus();
        taskStatus.setTaskId("1");
        taskStatus.setStatus(TaskStatus.Status.RUNNING);
        taskStatus.setPercentageComplete(150.5f);
        taskStatus.setTaskName(nome);

        System.out.println("Nome: "+nome);

        kafkaProducer.sendFlightEvent(taskStatus);
    }
}
