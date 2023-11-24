package com.example.RentalCars.service;

import com.example.RentalCars.dto.request.RentalCompanyRequestDTO;
import com.example.RentalCars.dto.response.RentalCompanyResponseDTO;
import com.example.RentalCars.exception.InvalidDataException;
import com.example.RentalCars.exception.ResourceNotFoundException;
import com.example.RentalCars.model.City;
import com.example.RentalCars.model.RentalCompany;
import com.example.RentalCars.repository.CityRepository;
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
    private CityRepository cityRepository;


    public List<RentalCompany> getAllRentalCompany() throws ResourceNotFoundException {
        return rentalCompanyRepository.findAll();
    }

    public List<RentalCompany> getRentalCompaniesByCity(Long city){
        return rentalCompanyRepository.findRentalCarByCityId(city);
    }


    public RentalCompanyResponseDTO createRentalCompany (RentalCompanyRequestDTO request) throws ResourceNotFoundException {
        City city = cityRepository.findById(request.getCityId())
                .orElseThrow(() -> new ResourceNotFoundException("Cidade não encontrada com id: " + request.getCityId()));

        RentalCompany rentalCompany = request.toRentalCompanyEntity(city);

        RentalCompany savedCompany = rentalCompanyRepository.save(rentalCompany);

        return new RentalCompanyResponseDTO(savedCompany.getId(), savedCompany.getName(), savedCompany.getCity().getId());

    }

}
