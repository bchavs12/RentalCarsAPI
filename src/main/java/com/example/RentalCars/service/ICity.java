package com.example.RentalCars.service;

import com.example.RentalCars.exception.InvalidDataException;
import com.example.RentalCars.exception.ResourceNotFoundException;
import com.example.RentalCars.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface ICity<TYPE, REQ, RES> {

    List<TYPE> getAllCities() throws ResourceNotFoundException;

    RES createCities(REQ requestDTO) throws InvalidDataException;

}
