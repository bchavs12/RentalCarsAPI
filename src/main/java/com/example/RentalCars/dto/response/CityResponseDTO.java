package com.example.RentalCars.dto.response;

import lombok.Data;
import java.util.List;

@Data
public class CityResponseDTO {
    private Long id;
    private String city;
    private String state;
    private List<RentalCompanyResponseDTO> companiesList;
}
