package com.example.RentalCars.service;

import com.example.RentalCars.exception.InvalidDataException;
import com.example.RentalCars.exception.ResourceNotFoundException;

import java.util.List;
import java.sql.SQLException;

public interface ICar<TYPE, REQ, RES>{
    List<TYPE> getAllCars() throws ResourceNotFoundException;
    RES createCar(REQ requestDTO) throws InvalidDataException;
}
