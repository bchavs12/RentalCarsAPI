package com.example.RentalCars.service;

import com.example.RentalCars.exception.InvalidDataException;
import com.example.RentalCars.exception.ResourceNotFoundException;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.List;
public interface ICategory<TYPE, REQ, RES> {

    List<TYPE> getAllCategories() throws ResourceNotFoundException;

    RES createCategory(REQ requestDTO) throws InvalidDataException;

}
