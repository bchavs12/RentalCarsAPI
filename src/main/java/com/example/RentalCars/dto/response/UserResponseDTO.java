package com.example.RentalCars.dto.response;

import com.example.RentalCars.model.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class UserResponseDTO {
    private Long id;
    private String username;

    private String fullName;
    private List<String> roles = new ArrayList<>();

    public UserResponseDTO() {
    }

    public UserResponseDTO(User entity) {
        id = entity.getId();
        fullName = entity.getFullName();
        username = entity.getUsername();
        for(GrantedAuthority role : entity.getRoles()) {
            roles.add(role.getAuthority());
        }
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
