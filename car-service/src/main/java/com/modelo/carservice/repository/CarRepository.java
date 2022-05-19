package com.modelo.carservice.repository;

import com.modelo.carservice.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car,Integer> {

    List<Car> findByUserId(int userId);
}
