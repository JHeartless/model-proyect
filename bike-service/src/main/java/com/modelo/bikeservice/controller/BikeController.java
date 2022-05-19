package com.modelo.bikeservice.controller;

import com.modelo.bikeservice.entity.Bike;
import com.modelo.bikeservice.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bike")
public class BikeController {

    @Autowired
    private BikeService bikeService;

    @GetMapping
    public ResponseEntity<List<Bike>> getAll(){
        List<Bike> bikes = bikeService.getAll();
        if (bikes.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(bikes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bike> getById(@PathVariable int id){
        Bike bike = bikeService.getBikeById(id);
        if (bike == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(bike);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Bike>> getByUserId(@PathVariable int userId){
        List<Bike> bike = bikeService.getBikeByUserId(userId);
        if (bike.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(bike);
    }

    @PostMapping
    public ResponseEntity<Bike> save(@RequestBody Bike bike){
        return ResponseEntity.ok(bikeService.save(bike));
    }
}
