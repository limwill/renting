package com.test.renting.repository;

import com.test.renting.models.Car;
import com.test.renting.models.StatusEnum;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * Repository used to generate our set of data when the application starts
 */
@Component
public class CarRepository {

    public static List<Car> listCars = new ArrayList<>();

    public static StatusEnum selectRandomStatus() {
        StatusEnum[] values = StatusEnum.values();
        int length = values.length;
        int randIndex = new Random().nextInt(length);
        return values[randIndex];
    }

    // We use UUID for the registrationNumber (even if it's not a correct registration number in real life)
    @PostConstruct
    public static void initCarRepository() {
        for (int i = 1; i < 26; i++) {
            listCars.add(new Car(i, UUID.randomUUID().toString(), selectRandomStatus()));
        }
    }
}
