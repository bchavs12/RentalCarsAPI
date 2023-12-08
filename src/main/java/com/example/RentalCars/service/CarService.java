package com.example.RentalCars.service;

import com.example.RentalCars.dto.request.CarRequestDTO;
import com.example.RentalCars.dto.response.CarResponseDTO;
import com.example.RentalCars.exception.ResourceNotFoundException;
import com.example.RentalCars.model.Car;
import com.example.RentalCars.model.Category;
import com.example.RentalCars.model.RentalCompany;
import com.example.RentalCars.repository.CarRepository;
import com.example.RentalCars.repository.CategoryRepository;
import com.example.RentalCars.repository.RentalCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CarService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private RentalCompanyRepository rentalCompanyRepository;
    @Autowired
    private CarRepository carRepository;

    public List<Car> getAllCars() throws ResourceNotFoundException {
        return carRepository.findAll();
    }

    public Car getCarById(Long id) throws ResourceNotFoundException {
        return carRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Carro não encontrado com id: " + id));
    }

    public List<Car> getCarsByCityName(String cityName) {
        return carRepository.findCarsByCityNameContaining(cityName);
    }

    public List<Car> getCarsByCategoryId(Long categoryId) {
        return carRepository.findCarsByCategoryId(categoryId);
    }

    public List<Car> getCarsByRentalCompanyId(Long rentalCompanyId) {
        return carRepository.findCarsByRentalCompanyId(rentalCompanyId);
    }

    public CarResponseDTO createCar(CarRequestDTO request) throws ResourceNotFoundException {
        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada com id: " + request.getCategoryId()));

        RentalCompany rentalCompany = rentalCompanyRepository.findById(request.getRentalCompanyId())
                .orElseThrow( () -> new ResourceNotFoundException("Locadora não encontrada com id: " + request.getRentalCompanyId()));
        Car car = request.toCarEntity(category, rentalCompany);

        Car savedCar = carRepository.save(car);
        return new CarResponseDTO(savedCar.getId(), savedCar.getBrand(), savedCar.getModel(),
                savedCar.getCarYear(), savedCar.getImageUrl(), savedCar.getPricePerDay(),
                savedCar.getIsAvailable(),savedCar.getDescription() ,savedCar.getCategory().getId(), savedCar.getRentalCompany().getId());
    }

    public CarResponseDTO updateCar(Long id, CarRequestDTO requestDTO) throws ResourceNotFoundException {
        Car carToUpdate = carRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Carro não encontrado com id: " + id));

        Category category = categoryRepository.findById(requestDTO.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada com id: " + requestDTO.getCategoryId()));
        RentalCompany rentalCompany = rentalCompanyRepository.findById(requestDTO.getRentalCompanyId())
                .orElseThrow(() -> new ResourceNotFoundException("Locadora não encontrada com id: " + requestDTO.getRentalCompanyId()));

        carToUpdate.setBrand(requestDTO.getBrand());
        carToUpdate.setModel(requestDTO.getModel());
        carToUpdate.setCarYear(requestDTO.getCarYear());
        carToUpdate.setImageUrl(requestDTO.getImageUrl());
        carToUpdate.setPricePerDay(requestDTO.getPricePerDay());
        carToUpdate.setIsAvailable(requestDTO.getIsAvailable());
        carToUpdate.setDescription(requestDTO.getDescription());
        carToUpdate.setCategory(category);
        carToUpdate.setRentalCompany(rentalCompany);

        Car updatedCar = carRepository.save(carToUpdate);

        return new CarResponseDTO(updatedCar);
    }

    public void deleteCar(Long id) throws ResourceNotFoundException {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Car not found with id: " + id));
        carRepository.delete(car);
    }
}
