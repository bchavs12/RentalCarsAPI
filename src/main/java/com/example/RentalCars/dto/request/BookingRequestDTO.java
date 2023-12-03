package com.example.RentalCars.dto.request;

import lombok.Data;

import java.sql.Time;
import java.time.LocalDate;

@Data
public class BookingRequestDTO {
    private Long carId;
    private Long userId;
    private Time bookingStart;
    private LocalDate bookingDate;
    private LocalDate returnDate;
}
