package com.example.RentalCars.dto.response;

import com.example.RentalCars.model.User;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.List;

public class UserResponseDTO {
    private Long id;
    private String username;
    private List<String> roles = new ArrayList<>();

    public UserResponseDTO(User entity) {
        id = entity.getId();
        username = entity.getUsername();
        for(GrantedAuthority role : entity.getRoles()) {
            roles.add(role.getAuthority());
        }
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public List<String> getRoles() {
        return roles;
    }
}
