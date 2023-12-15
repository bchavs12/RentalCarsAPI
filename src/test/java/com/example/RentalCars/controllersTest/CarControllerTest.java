package com.example.RentalCars.controllersTest;

import com.example.RentalCars.controller.CarController;
import com.example.RentalCars.dto.request.CarRequestDTO;
import com.example.RentalCars.dto.response.CarResponseDTO;
import com.example.RentalCars.repository.CarRepository;
import com.example.RentalCars.service.CarService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.BasicJsonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
class CarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarService carService;

    @Autowired
    private CarRepository carRepository;

    @Test
    @DisplayName("It should get all cars and return status 200(OK)")
    void getAllCarsSucessCase() throws Exception {

    }

    @Test
    @DisplayName("Should get cars by Id and return status 200(OK)")
    void getCarById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/cars/{id}", 3))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("Should get cars by Category Id and return 200(OK)")
    void getCarsByCategory() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/api/cars/category/{categoryId}",1))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @WithMockUser(username = "admin", roles = "ADMIN")
    void saveCar() throws Exception {
        // Mock CarRequestDTO
        CarRequestDTO requestDTO = new CarRequestDTO();

        // Mock CarResponseDTO
        CarResponseDTO responseDTO = new CarResponseDTO(
                1L,
                "Volkswagen",
                "Brasilia",
                1983,
                "image-url",
                50,
                true,
                "Description",
                2L,
                1L);

        when(carService.createCar(any(CarRequestDTO.class))).thenReturn(responseDTO);

        // Perform the request and assert the response
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/cars")
                        .header(HttpHeaders.AUTHORIZATION, "eyJraWQiOiI5MGYyNDdmMi1hNjRiLTQzZDItYTI5NS03ZWNlZTg5OGJjZDYiLCJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJteWNsaWVudGlkIiwiYXVkIjoibXljbGllbnRpZCIsIm5iZiI6MTcwMjU3NjEzOCwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgwIiwiZXhwIjoxNzAyNjYyNTM4LCJpYXQiOjE3MDI1NzYxMzgsImF1dGhvcml0aWVzIjpbIlJPTEVfQURNSU4iXSwidXNlcm5hbWUiOiJhZG1pbkBhZG1pbi5jb20ifQ.tlfQxQo6IWkrt7HSoBb0PLIYmhCZHgwgp74fcN7pgaoEPDLRDANMM4HNmT9ZejFJHM2BcYgojqRL1wilE0JT3SOH2arsgJYjRqhIMs2Pw6u6G9_9dOkB9CKT5aJ8WdXNul34sqRyBpyd4JHLuGN3ZHy-Sn3N1PXG5h_rRWDRpWO_NYjLUHxUhQpcvy3d4hKm-cllSJYAHT0rvRWpCLddV1vGK2ZpFGMxEQHj5IqHgsbSrbRyMAQ-TPk0I-l9ljEwZnfIlpOuVVIi-UsJwEOODcYgBkwWqa-BjI8EDk4AhbgocK-3UJ1UW1h4khZE9LXFKDBvMXlnnG-YqLOf-nZ13w")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(requestDTO)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(responseDTO.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.brand").value(responseDTO.getBrand()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.model").value(responseDTO.getModel()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.carYear").value(responseDTO.getCarYear()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.imageUrl").value(responseDTO.getImageUrl()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.pricePerDay").value(responseDTO.getPricePerDay()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.isAvailable").value(responseDTO.getIsAvailable()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value(responseDTO.getDescription()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.categoryId").value(responseDTO.getCategoryId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.rentalCompanyId").value(responseDTO.getRentalCompanyId()));

    }
}