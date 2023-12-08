package com.example.RentalCars.dto.response;

import com.example.RentalCars.model.Car;
import lombok.Data;

@Data
public class CarResponseDTO {
    private Long id;
    private String brand;
    private String model;
    private Integer carYear;
    private String imageUrl;
    private Integer pricePerDay;
    private Boolean isAvailable;
    private String description;
    private Long categoryId;
    private Long rentalCompanyId;

    public CarResponseDTO(Long id, String brand, String model, int carYear, String imageUrl, int pricePerDay, boolean isAvailable, String description, Long categoryId, Long rentalCompanyId) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.carYear = carYear;
        this.imageUrl = imageUrl;
        this.pricePerDay = pricePerDay;
        this.isAvailable = isAvailable;
        this.description = description;
        this.categoryId = categoryId;
        this.rentalCompanyId = rentalCompanyId;
    }

    public CarResponseDTO(Car updatedCar) {
        this.id = updatedCar.getId();
        this.brand = updatedCar.getBrand();
        this.model = updatedCar.getModel();
        this.carYear = updatedCar.getCarYear();
        this.imageUrl = updatedCar.getImageUrl();
        this.pricePerDay = updatedCar.getPricePerDay();
        this.isAvailable = updatedCar.getIsAvailable();
        this.description = updatedCar.getDescription();
        this.categoryId = updatedCar.getCategory() != null ? updatedCar.getCategory().getId() : null;
        this.rentalCompanyId = updatedCar.getRentalCompany() != null ? updatedCar.getRentalCompany().getId() : null;
    }
}
