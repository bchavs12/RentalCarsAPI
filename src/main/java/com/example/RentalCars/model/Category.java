package com.example.RentalCars.model;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Table(name = "TB_CATEGORIES")
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    //Mappings
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Car> cars;

}
