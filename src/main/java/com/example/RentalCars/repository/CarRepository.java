package com.example.RentalCars.repository;

import com.example.RentalCars.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    @Query("SELECT obj FROM Car obj WHERE obj.category.id = :categoryId")
    List<Car> findCarsByCategoryId(@Param("categoryId") Long categoryId);}
