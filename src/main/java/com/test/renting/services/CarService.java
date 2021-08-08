package com.test.renting.services;

import com.test.renting.controllers.exceptions.CarNotFoundException;
import com.test.renting.controllers.exceptions.ConflictException;
import com.test.renting.models.Car;
import com.test.renting.models.StatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.test.renting.repository.CarRepository.listCars;

@Service
@Slf4j
public class CarService {
    public List<Car> getCarsByStatus(StatusEnum status) {
        return listCars.stream().filter(car -> car.getStatus() == status).collect(Collectors.toList());
    }

    public Car updateCarStatus(int id, StatusEnum status) {
        Car car = listCars.stream().filter(c -> c.getId() == id).findFirst()
                .orElseThrow(() -> {
                    log.error("Car with id " + id + " doesn't exist");
                    throw new CarNotFoundException("Car with id " + id + " doesn't exist");
                });
        if (car != null && car.getStatus() == status) {
            log.error("Car with id " + id + " is already " + status);
            throw new ConflictException("Car with id " + id + " is already " + status);
        }
        car.setStatus(status);
        log.info("Car with id " + id + " is now " + status);
        return car;
    }
}
