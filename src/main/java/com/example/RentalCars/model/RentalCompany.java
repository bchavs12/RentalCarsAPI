package com.example.RentalCars.model;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Transactional
@NoArgsConstructor

@Table(name = "TB_RENTAL_COMPANIES")
@Entity
public class RentalCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String city;
    private String country;
    private String address;
    private String phoneNumber;

    @OneToMany(mappedBy = "rentalCompany", cascade = CascadeType.ALL)
    private List<Car> availableCars;

}
