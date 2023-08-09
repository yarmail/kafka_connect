package com.example.kafka_connect.controller;

import com.example.kafka_connect.model.Address;
import com.example.kafka_connect.model.UserDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

/**
 * Контроллер для приема обработки и отправки объектов UserDTO
 * Для упрощения слой Сервис для Продюсера не делал
 */
@RestController
@RequestMapping("user")
public class UserMsgControllerProducer {

    @Autowired
    private KafkaTemplate<Integer, UserDTO> userKafkaTemplate;

    @PostMapping
    public void sendMsg(Integer msgId, String name, Integer age) {
        UserDTO userDTO = new UserDTO();
        userDTO.setName(name);
        userDTO.setAge(age);
        userDTO.setAddress(new Address("RUS", "Msk", "Lenina", 1, 1));
        CompletableFuture<SendResult<Integer, UserDTO>> future =  userKafkaTemplate.send("user", msgId, userDTO);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("----------------");
                System.out.println("Сообщение успешно отправлено");
                System.out.println(userDTO);
                System.out.println("----------------");
            } else {
                System.out.println("----------------");
                System.out.println("Сообщение отправить не удалось");
                System.out.println(userDTO);
                System.out.println("----------------");
            }
        });
    }
}