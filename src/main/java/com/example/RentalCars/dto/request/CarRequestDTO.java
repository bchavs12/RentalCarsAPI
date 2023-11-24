package com.example.RentalCars.dto.request;

import com.example.RentalCars.model.Car;
import com.example.RentalCars.model.Category;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CarRequestDTO {
    private String brand;
    private String model;
    private Integer carYear;
    private String imageUrl;
    private Integer pricePerDay;
    private Boolean isAvailable;
    private Long categoryId;

    public Car toCarEntity(Category category) {
        Car car = new Car();
        car.setBrand(this.getBrand());
        car.setModel(this.getModel());
        car.setCarYear(this.getCarYear());
        car.setImageUrl(this.getImageUrl());
        car.setPricePerDay(this.getPricePerDay());
        car.setIsAvailable(this.getIsAvailable());
        car.setCategory(category);
        return car;
    }
}
