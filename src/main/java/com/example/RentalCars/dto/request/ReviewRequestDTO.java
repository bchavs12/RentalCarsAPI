package com.example.RentalCars.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReviewRequestDTO {
    private String comment;
    private Integer rating;
}
