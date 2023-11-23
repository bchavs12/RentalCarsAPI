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

        if (!carList.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(carList);
        } else{
            throw new ResourceNotFoundException("Erro! registro não encontrado!");
        }
    }

    @PostMapping
    public ResponseEntity<CarResponseDTO> saveCar(@RequestBody CarRequestDTO requestDTO) throws InvalidDataException {
        try{
            CarResponseDTO responseDTO = carService.createCar(requestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
        }catch (Exception ex){
            throw new InvalidDataException("Erro! Dados incorretos");
        }
    }

}
