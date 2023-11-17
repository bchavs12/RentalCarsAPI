package com.example.RentalCars.service;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.List;
public interface IReview<TYPE, REQ, RES> {
    List<TYPE> getAllReviews() throws SQLException;

    RES saveReview(REQ requestDTO) throws SQLDataException;
}
