package com.modelo.bikeservice.repository;

import com.modelo.bikeservice.entity.Bike;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BikeRepository extends JpaRepository<Bike,Integer> {

    List<Bike> findByUserId(int userId);
}
