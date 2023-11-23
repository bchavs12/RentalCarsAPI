package com.example.RentalCars.dto.response;

import lombok.Data;

import java.util.List;
@Data
public class RentalCompanyResponseDTO {
    private Long id;
    private String name;
    private List<CityResponseDTO> cities;
    private List<CarResponseDTO> availableCars;
}
