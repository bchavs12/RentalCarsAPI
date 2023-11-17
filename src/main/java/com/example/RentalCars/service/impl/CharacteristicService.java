package com.example.RentalCars.service.impl;

import com.example.RentalCars.dto.request.CharacteristicRequestDTO;
import com.example.RentalCars.dto.response.CharacteristicResponseDTO;
import com.example.RentalCars.model.Characteristic;
import com.example.RentalCars.service.ICharacteristic;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.List;

public class CharacteristicService implements ICharacteristic<Characteristic, CharacteristicRequestDTO, CharacteristicResponseDTO> {
    @Override
    public List<Characteristic> getAllCharacteristics() throws SQLException {
        return null;
    }

    @Override
    public CharacteristicResponseDTO saveCharacteristic(CharacteristicRequestDTO requestDTO) throws SQLDataException {
        return null;
    }
}
