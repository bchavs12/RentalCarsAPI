package com.example.RentalCars.model;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Transactional
@NoArgsConstructor

@Table(name = "TB_IMAGES")
@Entity
public class ImageUrl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titleAlt;
    private String url;

    @ManyToOne
    @JoinColumn(name = "fk_car_id", nullable = false)
    private Car car;
}
