package com.example.RentalCars.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReviewRequestDTO {
    private Integer rating;
    private String comment;
    private Long carId;
    private Long userId;
}
