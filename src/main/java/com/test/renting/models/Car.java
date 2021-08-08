package com.test.renting.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Car {
    private int id;
    private String registrationNumber;
    private StatusEnum status;
}
