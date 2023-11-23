package com.example.RentalCars.dto.request;

import com.example.RentalCars.dto.response.CategoryResponseDTO;
import com.example.RentalCars.dto.response.RentalCompanyResponseDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CarRequestDTO {
    private String brand;
    private String model;
    private Integer carYear;
    private String imageUrl;
    private Integer pricePerDay;
    private Boolean isAvailable;
    private Long categoryId;
}
