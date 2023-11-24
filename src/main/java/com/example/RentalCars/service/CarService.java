package com.example.RentalCars.service;

import com.example.RentalCars.dto.request.CarRequestDTO;
import com.example.RentalCars.dto.response.CarResponseDTO;
import com.example.RentalCars.exception.InvalidDataException;
import com.example.RentalCars.exception.ResourceNotFoundException;
import com.example.RentalCars.model.Car;
import com.example.RentalCars.model.Category;
import com.example.RentalCars.repository.CarRepository;
import com.example.RentalCars.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CarService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CarRepository carRepository;

    public List<Car> getAllCars() throws ResourceNotFoundException {
        return carRepository.findAll();
    }

    public List<Car> getCarsByCategoryId(Long categoryId) {
        return carRepository.findCarsByCategoryId(categoryId);
    }

    public CarResponseDTO createCar(CarRequestDTO request) throws ResourceNotFoundException {
        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada com id: " + request.getCategoryId()));

        Car car = request.toCarEntity(category);

        Car savedCar = carRepository.save(car);
        return new CarResponseDTO(savedCar.getId(), savedCar.getBrand(), savedCar.getModel(),
                savedCar.getCarYear(), savedCar.getImageUrl(), savedCar.getPricePerDay(),
                savedCar.getIsAvailable(), savedCar.getCategory().getId());
    }
}
