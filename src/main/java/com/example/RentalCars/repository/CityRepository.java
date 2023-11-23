package com.example.RentalCars.repository;

import com.example.RentalCars.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}
