package com.example.kafka_connect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Контроллер для приема и отправки простых сообщений типа String
 * Для упрощения слой Сервис для Продюсера не делал
 */
@RestController
@RequestMapping("msg")
public class SimpleMsgControllerProducer {

    @Autowired
    private KafkaTemplate<String, String> simpleKafkaTemplate;

    @PostMapping
    public void sendMsg(String msgId, String msg) {
    simpleKafkaTemplate.send("msg", msgId, msg);
    }
}
/*
Примечание
@RequestMapping("msg") - имя топика
String msgId - вводимый параметр
String msg - вводимый параметр
 */