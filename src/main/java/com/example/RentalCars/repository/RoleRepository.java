package com.example.RentalCars.repository;

import com.example.RentalCars.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByAuthority(String roleClient);
}
