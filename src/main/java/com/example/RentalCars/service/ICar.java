package com.example.RentalCars.service;

import java.util.List;
import java.sql.SQLException;

public interface ICar<TYPE, REQ, RES>{
    List<TYPE> getAllCars() throws SQLException;
    RES createCar(REQ requestDTO) throws SQLException;
}
