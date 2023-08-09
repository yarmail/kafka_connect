package com.example.kafka_connect.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Параметры адреса пользователя
 */
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Address {
    private String country;
    private String city;
    private String street;
    private Integer homeNumber;
    private Integer flatNumber;
}
