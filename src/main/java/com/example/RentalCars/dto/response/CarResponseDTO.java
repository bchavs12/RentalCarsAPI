package com.example.RentalCars.dto.response;

import lombok.Data;

@Data
public class CarResponseDTO {
    private Long id;
    private String brand;
    private String model;
    private Integer carYear;
    private String imageUrl;
    private Integer pricePerDay;
    private Boolean isAvailable;
    private Long categoryId;

    public CarResponseDTO(Long id, String brand, String model, int carYear, String imageUrl,
                          int pricePerDay, boolean isAvailable, Long categoryId) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.carYear = carYear;
        this.imageUrl = imageUrl;
        this.pricePerDay = pricePerDay;
        this.isAvailable = isAvailable;
        this.categoryId = categoryId;
    }
}
