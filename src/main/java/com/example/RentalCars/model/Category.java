package com.example.RentalCars.model;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Transactional
@NoArgsConstructor

@Table(name = "TB_CATEGORIES")
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String qualification;
    private String description;
    private String imageUrl;

    //Mappings
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Car> cars;

}
