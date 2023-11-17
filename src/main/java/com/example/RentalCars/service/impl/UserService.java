package com.example.RentalCars.service.impl;

import com.example.RentalCars.dto.request.UserRequestDTO;
import com.example.RentalCars.dto.response.UserResponseDTO;
import com.example.RentalCars.exception.InvalidDataException;
import com.example.RentalCars.exception.ResourceNotFoundException;
import com.example.RentalCars.model.User;
import com.example.RentalCars.repository.UserRepository;
import com.example.RentalCars.service.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.List;

@Service
public class UserService implements IUser<User, UserRequestDTO, UserResponseDTO> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() throws SQLException {
        return null;
    }

    @Override
    public UserResponseDTO createUser(UserRequestDTO requestDTO) throws SQLDataException {
        return null;
    }
}
