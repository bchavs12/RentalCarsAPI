package com.example.RentalCars.controller;

import com.example.RentalCars.dto.request.CityRequestDTO;
import com.example.RentalCars.dto.response.CityResponseDTO;
import com.example.RentalCars.exception.InvalidDataException;
import com.example.RentalCars.exception.ResourceNotFoundException;
import com.example.RentalCars.model.City;
import com.example.RentalCars.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/cities")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping
    public ResponseEntity<List<City>> getAllCities() throws ResourceNotFoundException{
        List<City> cityList = cityService.getAllCities();

        if (!cityList.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(cityList);
        }else {
            throw new ResourceNotFoundException("Erro! registro não encontrado");
        }
    }

    @PostMapping
    public ResponseEntity<CityResponseDTO> createCity(@RequestBody CityRequestDTO requestDTO) throws InvalidDataException{
        try{
            CityResponseDTO responseDTO = cityService.createCity(requestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
        }catch (Exception ex){
            throw new InvalidDataException("Informe todos os dados validos");
        }
    }
}
