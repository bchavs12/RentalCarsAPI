package com.example.RentalCars.repository;

import com.example.RentalCars.model.ImageUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<ImageUrl, Long> {
}
