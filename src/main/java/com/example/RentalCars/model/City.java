package com.example.RentalCars.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Table(name = "TB_CITIES")
@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String state;

    @OneToMany(mappedBy = "city")
    private List<RentalCompany> rentalCompanyList;
}

