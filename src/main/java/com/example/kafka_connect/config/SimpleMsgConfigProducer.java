package com.example.kafka_connect.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Вариант настройки поставщика, продюсера в котором
 * id сообщений имеют тип String
 * тело сообщения имеет тип String
 */
@Configuration
public class SimpleMsgConfigProducer {

    @Value("${spring.kafka.bootstrap-servers}")
    private String kafkaServer;

    @Bean
    public Map<String, Object> simpleProducerConfig() {
        Map<String, Object> properties = new HashMap<>();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServer);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return properties;
    }

    @Bean
    public ProducerFactory<String, String> simpleProducerFactory() {
        return new DefaultKafkaProducerFactory<>(simpleProducerConfig());
    }

    @Bean
    public KafkaTemplate<String, String> simpleKafkaTemplate() {
        return new KafkaTemplate<>(simpleProducerFactory());
    }
}