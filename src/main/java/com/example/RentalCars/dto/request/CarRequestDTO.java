package com.example.RentalCars.dto.request;

import lombok.Data;

@Data
public class CarRequestDTO {
    private String brand;
    private String model;
    private Integer carYear;
    private String description;
    private Double pricePerDay;
    private Boolean isAvailable;
    private Long categoryId;
    private Long rentalCompanyId;
}
