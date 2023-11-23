package com.example.RentalCars.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.util.List;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RentalCompanyRequestDTO {
    private String name;
    private Long cityId;
    private List<CarRequestDTO> availableCars;
}
