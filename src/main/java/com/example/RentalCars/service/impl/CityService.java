package com.example.RentalCars.service.impl;

import com.example.RentalCars.dto.request.CityRequestDTO;
import com.example.RentalCars.dto.response.CityResponseDTO;
import com.example.RentalCars.exception.InvalidDataException;
import com.example.RentalCars.exception.ResourceNotFoundException;
import com.example.RentalCars.model.City;
import com.example.RentalCars.repository.CityRepository;
import com.example.RentalCars.service.ICity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService implements ICity<City, CityRequestDTO, CityResponseDTO> {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<City> getAllCities() throws ResourceNotFoundException {
        return cityRepository.findAll();
    }

    @Override
    public CityResponseDTO createCities(CityRequestDTO requestDTO) throws InvalidDataException {
        try{
            City city = modelMapper.map(requestDTO, City.class);
            City savedCity = cityRepository.save(city);
            CityResponseDTO cityResponseDTO = modelMapper.map(savedCity, CityResponseDTO.class);
            return cityResponseDTO;
        }catch (Exception ex){
            throw new InvalidDataException("Erro! Dados incorretos");
        }
    }
}
