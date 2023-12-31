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

    @GetMapping()
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
    public ResponseEntity<List<BookingResponseDTO>> getAllBookings() throws ResourceNotFoundException {
        try{
            List<BookingResponseDTO> allBookings = bookingService.getAllBookings();
            return new ResponseEntity<>(allBookings, HttpStatus.OK);
        }catch (Exception ex){
            throw new ResourceNotFoundException("Resources not found it" + ex);
        }
    }

    @PostMapping()
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
    public ResponseEntity<BookingResponseDTO> createBooking(@RequestBody BookingRequestDTO requestDTO) throws InvalidDataException{
        try{
            BookingResponseDTO createdBooking = bookingService.createBooking(requestDTO);
            return new ResponseEntity<>(createdBooking, HttpStatus.CREATED);
        }catch (Exception ex){
            throw new InvalidDataException("It wasn't possible to create" + ex);
        }
    }

    @GetMapping("/user/{userId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
    public ResponseEntity<List<BookingResponseDTO>> getBookingsByUserId(@PathVariable Long userId) throws ResourceNotFoundException {
        try {
            List<BookingResponseDTO> userBookings = bookingService.getBookingsByUserId(userId);
            return new ResponseEntity<>(userBookings, HttpStatus.OK);
        } catch (Exception ex) {
            throw new ResourceNotFoundException("Bookings for the user id " + userId + " not found " + ex);
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
    public ResponseEntity<?> deleteBooking(@PathVariable Long id) {
        try {
            bookingService.deleteBooking(id);
            return ResponseEntity.ok().build();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao excluir a reserva: " + ex.getMessage());
        }
    }

}
