package com.example.RentalCars.service.impl;

import com.example.RentalCars.dto.request.CarRequestDTO;
import com.example.RentalCars.dto.response.CarResponseDTO;
import com.example.RentalCars.exception.InvalidDataException;
import com.example.RentalCars.exception.ResourceNotFoundException;
import com.example.RentalCars.model.Car;
import com.example.RentalCars.service.ICar;

import java.sql.SQLException;
import java.util.List;

public class CarService implements ICar<Car, CarRequestDTO, CarResponseDTO> {

    @Override
    public List<Car> getAllCars() throws SQLException {
        return null;
    }

    @Override
    public CarResponseDTO createCar(CarRequestDTO requestDTO) throws SQLException {
        return null;
    }
}
