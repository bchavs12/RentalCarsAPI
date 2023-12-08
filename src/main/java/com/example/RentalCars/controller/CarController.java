package com.example.RentalCars.controller;

import com.example.RentalCars.dto.request.CarRequestDTO;
import com.example.RentalCars.dto.response.CarResponseDTO;
import com.example.RentalCars.exception.InvalidDataException;
import com.example.RentalCars.exception.ResourceNotFoundException;
import com.example.RentalCars.model.Car;
import com.example.RentalCars.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping
    public ResponseEntity<List<Car>> getAllCars() throws ResourceNotFoundException{
        List<Car> carList = carService.getAllCars();
        return ResponseEntity.status(HttpStatus.OK).body(carList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id) throws ResourceNotFoundException {
        Car car = carService.getCarById(id);
        return ResponseEntity.ok(car);
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Car>> getCarsByCategory(@PathVariable Long categoryId) {
        List<Car> cars = carService.getCarsByCategoryId(categoryId);
        if (cars.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/city")
    public ResponseEntity<List<Car>> getCarsByCity(@RequestParam String city) {
        List<Car> cars = carService.getCarsByCityName(city);
        if (cars.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/company/{rentalCompanyId}")
        public ResponseEntity<List<Car>> getCarsByRentalCompanyId(@PathVariable Long rentalCompanyId){
            List<Car> cars = carService.getCarsByRentalCompanyId(rentalCompanyId);
            if (cars.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(cars);
    }


    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<CarResponseDTO> saveCar(@RequestBody CarRequestDTO requestDTO) throws InvalidDataException {
        try{
            CarResponseDTO responseDTO = carService.createCar(requestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
        }catch (Exception ex){
            throw new InvalidDataException("Erro! Dados incorretos");
        }
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<CarResponseDTO> updateCar(@PathVariable Long id, @RequestBody CarRequestDTO requestDTO) throws ResourceNotFoundException {
        CarResponseDTO updatedCar = carService.updateCar(id, requestDTO);
        return ResponseEntity.ok(updatedCar);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) throws ResourceNotFoundException {
        carService.deleteCar(id);
        return ResponseEntity.noContent().build();
    }


}
