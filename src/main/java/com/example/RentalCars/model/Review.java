package com.example.RentalCars.model;

import jakarta.persistence.*;

import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Transactional
@NoArgsConstructor

@Table(name = "TB_REVIEWS")
@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer rating; // rating scale 1 to 5
    private String comment;

    @ManyToOne
    @JoinColumn(name = "fk_car_id", nullable = false)
    private Car car;

    @ManyToOne
    @JoinColumn(name = "fk_user_id", nullable = false)
    private User user;
}