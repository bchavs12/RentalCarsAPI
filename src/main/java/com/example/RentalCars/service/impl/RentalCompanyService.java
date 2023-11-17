package com.example.RentalCars.service.impl;

import com.example.RentalCars.dto.request.RentalCompanyRequestDTO;
import com.example.RentalCars.dto.response.RentalCompanyResponseDTO;
import com.example.RentalCars.model.RentalCompany;
import com.example.RentalCars.service.IRentalCompany;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.List;

public class RentalCompanyService implements IRentalCompany<RentalCompany, RentalCompanyRequestDTO, RentalCompanyResponseDTO> {
    @Override
    public List<RentalCompany> getAllRentalCompany() throws SQLException {
        return null;
    }

    @Override
    public RentalCompanyResponseDTO saveRentalCompany(RentalCompanyRequestDTO requestDTO) throws SQLDataException {
        return null;
    }
}
