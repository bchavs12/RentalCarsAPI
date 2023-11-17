package com.example.RentalCars.dto.response;

import lombok.Data;

@Data
public class CharacteristicResponseDTO {
    private Long id;
    private String seats;
    private String trunk;
    private String icon;
    private Integer carDoors;
    private Long carId;
}
