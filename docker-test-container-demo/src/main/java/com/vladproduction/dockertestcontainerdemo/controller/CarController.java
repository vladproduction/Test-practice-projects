package com.vladproduction.dockertestcontainerdemo.controller;

import com.vladproduction.dockertestcontainerdemo.entity.Car;
import com.vladproduction.dockertestcontainerdemo.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by vladproduction on 18-Apr-24
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/docker-test-container-demo")
public class CarController {

    private final CarRepository carRepository;

    @GetMapping("/saveAllCars")
    public void saveCars(){
        Car car1 = new Car(1L, "BMW");
        Car car2 = new Car(2L, "Audi");
        Car car3 = new Car(3L, "Kia");
        carRepository.saveAll(List.of(car1, car2, car3));
    }

    @GetMapping("/getSavedCars")
    public List<Car> getSavedCars(){
        Car car1 = new Car(1L, "BMW");
        Car car2 = new Car(2L, "Audi");
        Car car3 = new Car(3L, "Kia");
        return carRepository.saveAll(List.of(car1, car2, car3));
    }
}
