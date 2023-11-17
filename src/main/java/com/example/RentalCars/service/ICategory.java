package com.example.RentalCars.service;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.List;
public interface ICategory<TYPE, REQ, RES> {

    List<TYPE> getAllCategories() throws SQLException;

    RES createCategory(REQ requestDTO) throws SQLDataException;

}
