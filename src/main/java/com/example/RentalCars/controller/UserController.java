package com.example.RentalCars.controller;

import com.example.RentalCars.dto.request.UserRequestDTO;
import com.example.RentalCars.dto.response.UserResponseDTO;
import com.example.RentalCars.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        List<UserResponseDTO> list = service.listAllUsers();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO userRequestDTO) {
        UserResponseDTO newUser = service.createUser(userRequestDTO);
        return ResponseEntity.ok(newUser);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable Long id, @RequestBody UserRequestDTO userRequestDTO) {
        UserResponseDTO updatedUser = service.updateUser(id, userRequestDTO);
        return ResponseEntity.ok(updatedUser);
    }
    @GetMapping(value = "/me")
    public ResponseEntity<UserResponseDTO> getMe(){
        UserResponseDTO dto = service.getMe();
        return ResponseEntity.ok(dto);
    }
}
