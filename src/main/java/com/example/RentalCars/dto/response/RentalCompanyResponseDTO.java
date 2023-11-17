package com.example.RentalCars.dto.response;

import java.util.List;
public class RentalCompanyResponseDTO {
    private Long id;
    private String name;
    private String city;
    private String country;
    private String address;
    private String phoneNumber;
    private List<Long> availableCarIds;
}
