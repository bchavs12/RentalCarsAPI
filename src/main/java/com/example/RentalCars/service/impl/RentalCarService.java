package com.example.RentalCars.service.impl;

import com.example.RentalCars.dto.request.RentalRequestDTO;
import com.example.RentalCars.dto.response.RentalResponseDTO;
import com.example.RentalCars.model.RentalCar;
import com.example.RentalCars.service.IRentalCar;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.List;

public class RentalCarService implements IRentalCar<RentalCar, RentalRequestDTO, RentalResponseDTO> {
    @Override
    public List<RentalCar> getAllRentalCars() throws SQLException {
        return null;
    }

    @Override
    public RentalResponseDTO createRentalCar(RentalRequestDTO requestDTO) throws SQLDataException {
        return null;
    }
}
