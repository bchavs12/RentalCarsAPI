package com.example.RentalCars.controller;

import com.example.RentalCars.model.Characteristic;
import com.example.RentalCars.service.CharacteristicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/characteristics")
public class CharacteristicController {

    @Autowired
    private CharacteristicService characteristicService;

    @GetMapping
    public ResponseEntity<List<Characteristic>> getAllCharacteristics() {
        return ResponseEntity.ok(characteristicService.findAll());
    }

    @PostMapping
    public ResponseEntity<Characteristic> createCharacteristic(@RequestBody Characteristic characteristic) {
        return ResponseEntity.ok(characteristicService.save(characteristic));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCharacteristic(@PathVariable Long id) {
        characteristicService.delete(id);
        return ResponseEntity.ok().build();
    }
}

