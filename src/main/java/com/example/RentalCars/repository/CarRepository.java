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
    List<Car> findCarsByCategoryId(@Param("categoryId") Long categoryId);
    @Query("SELECT obj FROM Car obj WHERE obj.rentalCompany.id = :rentalCompanyId")
    List<Car> findCarsByRentalCompanyId(@Param("rentalCompanyId") Long rentalCompanyId);

    @Query("SELECT c FROM Car c WHERE LOWER(c.rentalCompany.city.name) LIKE LOWER(CONCAT('%', :cityName, '%'))")
    List<Car> findCarsByCityNameContaining(@Param("cityName") String cityName);
}
