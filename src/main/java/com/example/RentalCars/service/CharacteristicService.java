package com.example.RentalCars.service;

import com.example.RentalCars.model.Car;
import com.example.RentalCars.model.Characteristic;
import com.example.RentalCars.repository.CarRepository;
import com.example.RentalCars.repository.CharacteristicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacteristicService {

    @Autowired
    private CharacteristicRepository characteristicRepository;
    @Autowired
    private CarRepository carRepository;

    public List<Characteristic> findAll() {
        return characteristicRepository.findAll();
    }

    public Characteristic save(Characteristic characteristic) {
        return characteristicRepository.save(characteristic);
    }

    public Characteristic linkCharacteristicToCar(Long characteristicId, Long carId) {
        Characteristic characteristic = characteristicRepository.findById(characteristicId)
                .orElseThrow(() -> new IllegalStateException("Characteristic not found with id: " + characteristicId));
        Car car = carRepository.findById(carId)
                .orElseThrow(() -> new IllegalStateException("Car not found with id: " + carId));

        characteristic.setCar(car);
        return characteristicRepository.save(characteristic);
    }

    public void delete(Long id) {
        characteristicRepository.deleteById(id);
    }
}

