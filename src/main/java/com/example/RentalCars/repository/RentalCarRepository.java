package com.example.RentalCars.repository;

import com.example.RentalCars.model.Car;
import com.example.RentalCars.model.RentalCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentalCarRepository extends JpaRepository<RentalCar, Long> {

}

