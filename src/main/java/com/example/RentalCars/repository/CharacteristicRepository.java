package com.example.RentalCars.repository;

import com.example.RentalCars.model.Characteristic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacteristicRepository extends JpaRepository<Characteristic, Long> {
}
