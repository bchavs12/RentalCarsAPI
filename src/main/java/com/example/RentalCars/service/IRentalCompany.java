package com.example.RentalCars.service;


import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.List;
public interface IRentalCompany<TYPE, REQ, RES> {

    List<TYPE> getAllRentalCompany() throws SQLException;

    RES saveRentalCompany(REQ requestDTO) throws SQLDataException;

}
