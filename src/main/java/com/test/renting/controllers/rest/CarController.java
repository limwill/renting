package com.test.renting.controllers.rest;

import com.test.renting.models.Car;
import com.test.renting.models.StatusEnum;
import com.test.renting.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping(value = "/status", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Car> getCarsByStatus(@RequestParam StatusEnum status) {
        return carService.getCarsByStatus(status);
    }

    @PatchMapping(value = "/status/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Car updateCarStatus(@PathVariable int id, @RequestBody StatusEnum status) {
        return carService.updateCarStatus(id, status);
    }
}
