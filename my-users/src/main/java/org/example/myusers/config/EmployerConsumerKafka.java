package org.example.myusers.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.example.baseservice.event.ServicesEmployerEvens;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;
@Configuration
public class EmployerConsumerKafka {
    @Bean
    public ConsumerFactory<String, ServicesEmployerEvens> EventConsumer() {
        Map<String, Object> map = new HashMap<>();
        map.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:19092");
        map.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        map.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        map.put(JsonDeserializer.TYPE_MAPPINGS, "org.example.baseservice.event.ServicesEmployerEvens:org.example.baseservice.event.ServicesEmployerEvens");
        return new DefaultKafkaConsumerFactory<>(map, new StringDeserializer(), new JsonDeserializer<>(ServicesEmployerEvens.class));
    }
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, ServicesEmployerEvens> EventListner(){
        ConcurrentKafkaListenerContainerFactory<String, ServicesEmployerEvens> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(EventConsumer());
        return factory;
    }
}
