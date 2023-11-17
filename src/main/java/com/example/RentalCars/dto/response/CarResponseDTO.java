package com.example.RentalCars.dto.response;

import lombok.Data;

@Data
public class CarResponseDTO {
    private Long id;
    private String brand;
    private String model;
    private Integer carYear;
    private String description;
    private Double pricePerDay;
    private Boolean isAvailable;
    private Long categoryId;
    private Long rentalCompanyId;
}
