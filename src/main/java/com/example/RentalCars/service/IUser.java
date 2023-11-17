package com.example.RentalCars.service;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.List;
public interface IUser <TYPE, REQ, RES>{

    List<TYPE> getAllUsers() throws SQLException;

    RES createUser(REQ requestDTO) throws SQLDataException;

}
