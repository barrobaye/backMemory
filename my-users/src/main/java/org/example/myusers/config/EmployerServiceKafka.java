package org.example.myusers.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.baseservice.event.EmployerEvens;
import org.example.myusers.service.EmployerService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class EmployerServiceKafka {
    private final EmployerService employerService;
    @KafkaListener(topics = "employer-event-topic", groupId = "default", containerFactory = "EventListner")
    public void getResponse(EmployerEvens employerEvens) {
        employerService.updateEmployer(employerEvens);
    }

}
