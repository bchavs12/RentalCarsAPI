package com.example.RentalCars.repository;

import com.example.RentalCars.model.RentalCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentalCompanyRepository extends JpaRepository<RentalCompany, Long> {
    @Query("SELECT rc FROM RentalCompany rc WHERE rc.city.id = :city")
    List<RentalCompany> findRentalCarByCityId(@Param("city") Long city);
}
