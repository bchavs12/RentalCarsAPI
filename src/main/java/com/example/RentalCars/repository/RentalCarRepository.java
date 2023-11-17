package com.example.RentalCars.repository;

import com.example.RentalCars.model.RentalCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalCarRepository extends JpaRepository<RentalCar, Long> {
}
