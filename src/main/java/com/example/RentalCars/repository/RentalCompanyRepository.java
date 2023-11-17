package com.example.RentalCars.repository;

import com.example.RentalCars.model.RentalCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalCompanyRepository extends JpaRepository<RentalCompany, Long> {
}
