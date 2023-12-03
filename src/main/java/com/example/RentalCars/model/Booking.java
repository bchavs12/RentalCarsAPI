package com.example.RentalCars.model;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.Data;

import java.sql.Time;
import java.time.LocalDate;

@Data
@Transactional

@Table(name = "TB_BOOKINGS")
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fk_car_id")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "fk_user_id")
    private User user;

    @Temporal(TemporalType.TIME)
    private Time bookingStart;

    @Temporal(TemporalType.DATE)
    private LocalDate bookingDate;

    @Temporal(TemporalType.DATE)
    private LocalDate returnDate;


}
