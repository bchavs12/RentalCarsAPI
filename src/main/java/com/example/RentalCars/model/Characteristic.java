package com.example.RentalCars.model;

import jakarta.persistence.*;

import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Transactional
@NoArgsConstructor

@Table(name = "TB_CHARACTERISTICS")
@Entity
public class Characteristic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String seats;  //assentos
    private String trunk; //Porta-malas
    private String icon;
    private Integer carDoors;

    @ManyToOne
    @JoinColumn(name = "fk_car_id")
    private Car car;
}