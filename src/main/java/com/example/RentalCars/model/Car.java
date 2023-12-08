package com.example.RentalCars.model;

import com.example.RentalCars.dto.request.CarRequestDTO;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;


@Table(name = "TB_CARS")
@Entity
@Data
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;
    private String model;
    private Integer carYear;
    private String imageUrl;
    private Integer pricePerDay;
    private Boolean isAvailable;
    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    @JoinColumn(name = "fk_category_id", nullable = false)
    private Category category;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private List<Characteristic> characteristic;

    @ManyToOne
    @JoinColumn(name = "fk_rental_company_id")
    private RentalCompany rentalCompany;
}


