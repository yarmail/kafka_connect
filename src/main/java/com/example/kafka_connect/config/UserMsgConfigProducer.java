package com.example.kafka_connect.config;

import com.example.kafka_connect.model.UserDTO;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.IntegerSerializer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

/**
 * Вариант настройки поставщика (продюсера) в котором
 * id сообщений имеют тип Integer
 * тело сообщения имеет тип UserDTO
 *
 * В качестве сериализатора значения сообщения укажем JsonSerializer.class
 * и не забудем везде изменить тип String на UserDto.
 */
@Configuration
public class UserMsgConfigProducer {

    @Value("${spring.kafka.bootstrap-servers}")
    private String kafkaServer;

    @Bean
    public Map<String, Object> userProducerConfig() {
        Map<String, Object> properties = new HashMap<>();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServer);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return properties;
    }

    @Bean
    public ProducerFactory<Integer, UserDTO> userProducerFactory() {
        return new DefaultKafkaProducerFactory<>(userProducerConfig());
    }

    @Bean
    public KafkaTemplate<Integer, UserDTO> userKafkaTemplate() {
        return new KafkaTemplate<>(userProducerFactory());
    }
}