package org.example.myservices.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.baseservice.event.EmployerEvens;
import org.example.baseservice.event.ServicesEmployerEvens;
import org.example.myservices.services.ServiceEmployer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ServiceEmployerKafka {
    private final ServiceEmployer serviceEmployer;
    private final String  EMPLOYER_SERVICE_TOPIC = "employer_service-event-topic";
    private final KafkaTemplate <String, ServicesEmployerEvens> kafkaTemplate;

    public  void consumeMessageEmployer(EmployerEvens employerEvens){
        log.info("message consume {}" , employerEvens.getEvensId());
    try {
        ServicesEmployerEvens servicesEmployerEvens = serviceEmployer.saveEmployerServices(employerEvens);
        kafkaTemplate.send(EMPLOYER_SERVICE_TOPIC,servicesEmployerEvens);
    }catch (Exception e){
        e.printStackTrace();
    }
    }
}
