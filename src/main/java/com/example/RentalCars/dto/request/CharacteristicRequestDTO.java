package com.example.RentalCars.dto.request;

import lombok.Data;

@Data
public class CharacteristicRequestDTO {
    private String seats;
    private String trunk;
    private String icon;
    private Integer carDoors;
    private Long carId;
}
