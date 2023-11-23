package com.example.RentalCars.service;


import com.example.RentalCars.exception.InvalidDataException;
import com.example.RentalCars.exception.ResourceNotFoundException;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.List;
public interface IRentalCompany<TYPE, REQ, RES> {

    List<TYPE> getAllRentalCompany() throws ResourceNotFoundException;

    RES saveRentalCompany(REQ requestDTO) throws InvalidDataException;

}
