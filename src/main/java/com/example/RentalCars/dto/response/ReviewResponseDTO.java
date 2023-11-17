package com.example.RentalCars.dto.response;

import lombok.Data;

@Data
public class ReviewResponseDTO {
    private Long id;
    private String comment;
    private Integer rating;
}
