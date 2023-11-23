package com.example.RentalCars.dto.response;

import lombok.Data;

@Data
public class CarResponseDTO {
    private Long id;
    private String brand;
    private String model;
    private Integer carYear;
    private Integer pricePerDay;
    private Boolean isAvailable;
    private CategoryResponseDTO category;
    private RentalCompanyResponseDTO rentalCompany;
}
