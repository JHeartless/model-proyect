package com.modelo.carservice.controller;


import com.modelo.carservice.entity.Car;
import com.modelo.carservice.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping
    public ResponseEntity<List<Car>> getAll(){
        List<Car> cars = carService.getAll();
        if (cars.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getById(@PathVariable int id){
        Car car = carService.getCarById(id);
        if (car == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(car);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Car>> getByUserId(@PathVariable int userId){
        List<Car> car = carService.getCarByUserId(userId);
        if (car.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(car);
    }

    @PostMapping
    public ResponseEntity<Car> save(@RequestBody Car car){
        return ResponseEntity.ok(carService.save(car));
    }

}
