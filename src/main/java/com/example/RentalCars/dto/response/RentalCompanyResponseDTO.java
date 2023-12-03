package com.example.RentalCars.dto.response;

import lombok.Data;

@Data
public class RentalCompanyResponseDTO {
    private Long id;
    private String name;
    private Long cityId;



    public RentalCompanyResponseDTO(Long id, String name, Long cityId) {
        this.id = id;
        this.name = name;
        this.cityId = cityId;
    }
}
