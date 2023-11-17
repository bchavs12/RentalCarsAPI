package com.example.RentalCars.service;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.List;
public interface ICharacteristic<TYPE, REQ, RES> {

    List<TYPE> getAllCharacteristics() throws SQLException;

    RES saveCharacteristic(REQ requestDTO) throws SQLDataException;

}
