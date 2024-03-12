package org.example.myservices.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.example.baseservice.event.EmployerEvens;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;
@Configuration
public class ServiceEmployerConsumerKafka {

    public  <T> ConsumerFactory<String, T> createConsumerFactory(Class<T> eventType){
        Map<String, Object> map = new HashMap<>();
        map.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:29092");
        map.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        map.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        map.put(JsonDeserializer.TYPE_MAPPINGS, eventType.getName() + ":" + eventType.getName());
        return new DefaultKafkaConsumerFactory<>(map);

    }
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, EmployerEvens> eventListenerClient() {
        ConcurrentKafkaListenerContainerFactory<String, EmployerEvens> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(createConsumerFactory(EmployerEvens.class));
        return factory;
    }


}
