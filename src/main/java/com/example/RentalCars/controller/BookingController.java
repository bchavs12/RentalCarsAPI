package com.example.RentalCars.controller;

import com.example.RentalCars.dto.request.BookingRequestDTO;
import com.example.RentalCars.dto.response.BookingResponseDTO;
import com.example.RentalCars.exception.InvalidDataException;
import com.example.RentalCars.exception.ResourceNotFoundException;
import com.example.RentalCars.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/all")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
    public ResponseEntity<List<BookingResponseDTO>> getAllBookings() throws ResourceNotFoundException {
        try{
            List<BookingResponseDTO> allBookings = bookingService.getAllBookings();
            return new ResponseEntity<>(allBookings, HttpStatus.OK);
        }catch (Exception ex){
            throw new ResourceNotFoundException("Resources not found it" + ex);
        }
    }

    @PostMapping("/create")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
    public ResponseEntity<BookingResponseDTO> createBooking(@RequestBody BookingRequestDTO requestDTO) throws InvalidDataException{
        try{
            BookingResponseDTO createdBooking = bookingService.createBooking(requestDTO);
            return new ResponseEntity<>(createdBooking, HttpStatus.CREATED);
        }catch (Exception ex){
            throw new InvalidDataException("It wasn't possible to create" + ex);
        }
    }

}
