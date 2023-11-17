package com.example.RentalCars.model;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Transactional
@NoArgsConstructor

@Table(name = "TB_RENTALS")
@Entity
public class RentalCar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fk_car_id")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "fk_user_id")
    private User user;

    @Temporal(TemporalType.TIMESTAMP)
    private Date rentalDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date returnDate;


}
