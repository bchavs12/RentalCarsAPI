package com.example.RentalCars.service.impl;

import com.example.RentalCars.dto.request.CarRequestDTO;
import com.example.RentalCars.dto.response.CarResponseDTO;
import com.example.RentalCars.exception.InvalidDataException;
import com.example.RentalCars.exception.ResourceNotFoundException;
import com.example.RentalCars.model.Car;
import com.example.RentalCars.repository.CarRepository;
import com.example.RentalCars.service.ICar;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
@Service
public class CarService implements ICar<Car, CarRequestDTO, CarResponseDTO> {

    @Autowired
    private CarRepository carRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Car> getAllCars() throws ResourceNotFoundException {
        return carRepository.findAll();
    }

    @Override
    public CarResponseDTO createCar(CarRequestDTO requestDTO) throws InvalidDataException {
        try{
            Car car = modelMapper.map(requestDTO, Car.class);
            Car savedCar = carRepository.save(car);
            CarResponseDTO carResponseDTO = modelMapper.map(savedCar, CarResponseDTO.class);
            return carResponseDTO;
        }catch (Exception ex){
            throw new InvalidDataException("Erro! Dados incorretos");
        }
    }
}
