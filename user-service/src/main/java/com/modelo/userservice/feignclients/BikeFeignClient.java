package com.modelo.userservice.feignclients;


import com.modelo.userservice.model.Bike;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "bike-service" , url = "http://localhost:8003")
@RequestMapping("/bike")
public interface BikeFeignClient {

    @PostMapping
    public Bike save(@RequestBody Bike bike);
}
