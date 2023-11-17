package com.example.RentalCars.service;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.List;
public interface IImage<TYPE, REQ, RES> {

    List<TYPE> getAllImages() throws SQLException;

    RES saveImage(REQ requestDTO) throws SQLDataException;

}
