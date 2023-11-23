package com.example.RentalCars.dto.response;

import lombok.Data;
import java.util.List;

@Data
public class CategoryResponseDTO {
    private Long id;
    private String name;
    private String description;
    private List<CarResponseDTO> carList;
}
