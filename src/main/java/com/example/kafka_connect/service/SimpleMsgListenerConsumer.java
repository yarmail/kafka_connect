package com.example.kafka_connect.service;

import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * Получатель, Потребитель, Consumer простых сообщений
 */

@Service
@EnableKafka
public class SimpleMsgListenerConsumer {

    @KafkaListener(topics = "msg")
    public void msgListener(String msg) {
        System.out.println("-------------");
        System.out.println("Это Получатель. Сообщение от Поставщика получено " + msg);
        System.out.println("-------------");
    }
}