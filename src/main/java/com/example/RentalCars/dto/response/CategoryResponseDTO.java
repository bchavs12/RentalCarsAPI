package com.example.RentalCars.dto.response;

import lombok.Data;

@Data
public class CategoryResponseDTO {
    private Long id;
    private String name;
    private String description;
    private String imageUrl;
}
