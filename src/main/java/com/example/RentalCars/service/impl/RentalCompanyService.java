package com.example.RentalCars.service.impl;

import com.example.RentalCars.dto.request.RentalCompanyRequestDTO;
import com.example.RentalCars.dto.response.RentalCompanyResponseDTO;
import com.example.RentalCars.exception.InvalidDataException;
import com.example.RentalCars.exception.ResourceNotFoundException;
import com.example.RentalCars.model.RentalCompany;
import com.example.RentalCars.repository.RentalCarRepository;
import com.example.RentalCars.repository.RentalCompanyRepository;
import com.example.RentalCars.service.IRentalCompany;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.List;
@Service
public class RentalCompanyService implements IRentalCompany<RentalCompany, RentalCompanyRequestDTO, RentalCompanyResponseDTO> {

    @Autowired
    private RentalCompanyRepository rentalCompanyRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<RentalCompany> getAllRentalCompany() throws ResourceNotFoundException {
        return rentalCompanyRepository.findAll();
    }

    @Override
    public RentalCompanyResponseDTO saveRentalCompany(RentalCompanyRequestDTO requestDTO) throws InvalidDataException {
        try{
            RentalCompany rentalCompany = modelMapper.map(requestDTO, RentalCompany.class);
            RentalCompany savedRentalCompany = rentalCompanyRepository.save(rentalCompany);
            RentalCompanyResponseDTO responseDTO = modelMapper.map(savedRentalCompany, RentalCompanyResponseDTO.class);
            return responseDTO;
        }catch (Exception ex){
            throw new InvalidDataException("Erro! Dados incorretos");
        }
    }
}
