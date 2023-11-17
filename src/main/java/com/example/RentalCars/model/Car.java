package com.example.RentalCars.model;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Transactional
@NoArgsConstructor

@Table(name = "TB_CARS")
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;
    private String model;
    private Integer carYear;
    private String description;
    private Float price_per_day;
    private Boolean isAvailable;

    //Mappings
    @ManyToOne
    @JoinColumn(name = "fk_category_id", nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "fk_rental_company_id")
    private RentalCompany rentalCompany;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private List<ImageUrl> imagesList;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private List<Characteristic> characteristic;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private List<Review> reviews;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private List<RentalCar> rentalCars;
}


