package com.example.RentalCars.dto.response;

import lombok.Data;
import org.springframework.data.relational.core.mapping.Embedded;

import java.util.List;
@Data
public class RentalCompanyResponseDTO {
    private Long id;
    private String name;
    private CityResponseDTO city;
    private List<CarResponseDTO> availableCars;
}
