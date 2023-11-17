package com.example.RentalCars.service;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.List;
public interface IRentalCar<TYPE, REQ, RES> {

    List<TYPE> getAllRentalCars() throws SQLException;

    RES createRentalCar(REQ requestDTO) throws SQLDataException;

}
