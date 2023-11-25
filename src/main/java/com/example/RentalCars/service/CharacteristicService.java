package com.example.RentalCars.service;

import com.example.RentalCars.model.Characteristic;
import com.example.RentalCars.repository.CharacteristicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacteristicService {

    @Autowired
    private CharacteristicRepository characteristicRepository;

    public List<Characteristic> findAll() {
        return characteristicRepository.findAll();
    }

    public Characteristic save(Characteristic characteristic) {
        return characteristicRepository.save(characteristic);
    }

    public void delete(Long id) {
        characteristicRepository.deleteById(id);
    }
}

