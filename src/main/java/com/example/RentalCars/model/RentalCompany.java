package com.example.RentalCars.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "TB_RENTAL_COMPANIES")
@Entity
public class RentalCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "city")
    private City city;

    //@OneToMany(mappedBy = "rentalCompany", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   // private List<Car> availableCars;

}
