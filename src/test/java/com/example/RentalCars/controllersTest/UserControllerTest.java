package com.example.RentalCars.controllersTest;

import com.example.RentalCars.dto.response.UserResponseDTO;
import com.example.RentalCars.repository.UserRepository;
import com.example.RentalCars.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("It should get all users and return status 200(OK)")
    void getAllUsersSucessCase() throws Exception {
       mockMvc.perform(MockMvcRequestBuilders.get("/api/users"))
               .andDo(MockMvcResultHandlers.print())
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(userRepository.count()));
    }

    @Test
    void createUser() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void getMe() {
    }
}