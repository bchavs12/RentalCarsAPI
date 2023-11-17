package com.example.RentalCars.service.impl;

import com.example.RentalCars.dto.request.ReviewRequestDTO;
import com.example.RentalCars.dto.response.ReviewResponseDTO;
import com.example.RentalCars.model.Review;
import com.example.RentalCars.service.IReview;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.List;

public class ReviewService implements IReview<Review, ReviewRequestDTO, ReviewResponseDTO> {
    @Override
    public List<Review> getAllReviews() throws SQLException {
        return null;
    }

    @Override
    public ReviewResponseDTO saveReview(ReviewRequestDTO requestDTO) throws SQLDataException {
        return null;
    }
}
