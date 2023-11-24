package com.example.RentalCars.model;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Transactional
@NoArgsConstructor

@Table(name = "TB_USERS")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String email;
    private String fullName;

    @OneToOne(mappedBy = "user")
    private RentalCar currentRentalCar;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Review> reviewList;
}
