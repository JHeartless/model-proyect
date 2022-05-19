package com.modelo.userservice.controller;

import com.modelo.userservice.entity.User;
import com.modelo.userservice.model.Bike;
import com.modelo.userservice.model.Car;
import com.modelo.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAll(){
        List<User> users = userService.getAll();
        if (users.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getAll(@PathVariable int id){
        User user = userService.getUserById(id);
        if (user == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user){
        return ResponseEntity.ok(userService.save(user));
    }

    //RESTTEMPLATE
    @GetMapping("/car/{userId}")
    public ResponseEntity<List<Car>> getCars(@PathVariable int userId){
        User user = userService.getUserById(userId);
        if (user == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userService.getCars(userId));
    }

    @GetMapping("/bike/{userId}")
    public ResponseEntity<List<Bike>> getBikes(@PathVariable int userId){
        User user = userService.getUserById(userId);
        if (user == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userService.getBikes(userId));
    }

    //FEIGN
    @PostMapping("/savecar/{userId}")
    public ResponseEntity<Car> saveCar(@PathVariable int userId,@RequestBody Car car){
        Car carNew = userService.saveCar(userId, car);
        return ResponseEntity.ok(car);
    }

    @PostMapping("/savebike/{userId}")
    public ResponseEntity<Bike> saveBike(@PathVariable int userId,@RequestBody Bike bike){
        Bike bikeNew = userService.saveBike(userId, bike);
        return ResponseEntity.ok(bike);
    }
}
