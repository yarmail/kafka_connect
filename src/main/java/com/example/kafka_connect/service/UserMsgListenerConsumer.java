package com.example.kafka_connect.service;

import com.example.kafka_connect.model.UserDTO;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@EnableKafka
public class UserMsgListenerConsumer {

    @KafkaListener(topics = "user")
    public void userListener(ConsumerRecord<Integer, UserDTO> record) {
        System.out.println("------------------------");
        System.out.println("Сообщение получено Получателем от Постащика");
        System.out.println("Ключ сообщения: " + record.key());
        System.out.println("Тело (значение) сообщения: " + record.value());
        System.out.println("--------------------------");

    }
}