package com.example.RentalCars.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

@Table(name = "TB_CHARACTERISTICS")
@Entity
public class Characteristic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String seats;
    private String trunk;
    private Integer carDoors;

    @ManyToOne
    @JoinColumn(name = "fk_car_id")
    @JsonIgnore
    private Car car;
}