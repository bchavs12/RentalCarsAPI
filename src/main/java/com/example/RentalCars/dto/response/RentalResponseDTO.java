package com.example.RentalCars.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
public class RentalResponseDTO {
    private Long id;
    private Long carId;
    private Long userId;
}
