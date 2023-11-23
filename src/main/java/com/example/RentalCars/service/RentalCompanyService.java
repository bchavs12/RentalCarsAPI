package com.example.RentalCars.service;

import com.example.RentalCars.dto.request.RentalCompanyRequestDTO;
import com.example.RentalCars.dto.response.RentalCompanyResponseDTO;
import com.example.RentalCars.exception.InvalidDataException;
import com.example.RentalCars.exception.ResourceNotFoundException;
import com.example.RentalCars.model.RentalCompany;
import com.example.RentalCars.repository.RentalCompanyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Service
public class RentalCompanyService {

    @Autowired
    private RentalCompanyRepository rentalCompanyRepository;
    @Autowired
    private ModelMapper modelMapper;


    public List<RentalCompany> getAllRentalCompany() throws ResourceNotFoundException {
        return rentalCompanyRepository.findAll();
    }


    public RentalCompanyResponseDTO createRentalCompany(@RequestBody RentalCompanyRequestDTO requestDTO) throws InvalidDataException{
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
