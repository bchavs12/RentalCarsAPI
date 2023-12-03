package com.example.RentalCars.dto.response;

import lombok.Data;

@Data
public class ReviewResponseDTO {
    private Long id;
    private Integer rating;
    private String comment;
    private Long carId;
    private Long userId;
}
