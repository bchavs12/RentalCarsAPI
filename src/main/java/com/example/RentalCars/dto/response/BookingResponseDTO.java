package com.example.RentalCars.dto.response;

import lombok.Data;

import java.sql.Time;
import java.time.LocalDate;

@Data
public class BookingResponseDTO {
    private Long id;
    private Long carId;
    private Long userId;
    private Time bookingStart;
    private LocalDate bookingDate;
    private LocalDate returnDate;
}
