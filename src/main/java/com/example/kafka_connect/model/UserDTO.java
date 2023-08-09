package com.example.kafka_connect.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class UserDTO {
    private Integer age;
    private String name;
    private Address address;
}
