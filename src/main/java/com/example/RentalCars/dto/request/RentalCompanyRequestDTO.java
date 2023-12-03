package com.example.RentalCars.dto.request;

import com.example.RentalCars.model.City;
import com.example.RentalCars.model.RentalCompany;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RentalCompanyRequestDTO {
    private String name;
    private Long cityId;


    public RentalCompany toRentalCompanyEntity (City city){
        RentalCompany rentalCompany = new RentalCompany();
        rentalCompany.setName(this.getName());
        rentalCompany.setCity(city);

        return rentalCompany;
    }
}
