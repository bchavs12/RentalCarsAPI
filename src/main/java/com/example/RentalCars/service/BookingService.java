package com.example.RentalCars.service;

import com.example.RentalCars.dto.request.BookingRequestDTO;
import com.example.RentalCars.dto.response.BookingResponseDTO;
import com.example.RentalCars.exception.InvalidDataException;
import com.example.RentalCars.model.Booking;
import com.example.RentalCars.model.Car;
import com.example.RentalCars.model.User;
import com.example.RentalCars.repository.BookingRepository;
import com.example.RentalCars.repository.CarRepository;
import com.example.RentalCars.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingService {
    private BookingRepository bookingRepository;
    private CarRepository carRepository;
    private UserRepository userRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository, CarRepository carRepository, UserRepository userRepository) {
        this.bookingRepository = bookingRepository;
        this.carRepository = carRepository;
        this.userRepository = userRepository;
    }

    public BookingResponseDTO createBooking(BookingRequestDTO requestDTO) throws InvalidDataException {
        User user = userRepository.findById(requestDTO.getUserId())
                .orElseThrow(() -> new InvalidDataException("User not found with id: " + requestDTO.getUserId()));

        if (user.getCurrentBooking() != null) {
            throw new InvalidDataException("User already has an active booking.");
        }

        Booking booking = new Booking();
        booking.setBookingStart(requestDTO.getBookingStart());
        booking.setBookingDate(requestDTO.getBookingDate());
        booking.setReturnDate(requestDTO.getReturnDate());

        Car car = carRepository.findById(requestDTO.getCarId())
                .orElseThrow(() -> new InvalidDataException("Car not found with id: " + requestDTO.getCarId()));
        booking.setCar(car);

        booking.setUser(user);

        Booking savedBooking = bookingRepository.save(booking);
        user.setCurrentBooking(savedBooking);
        userRepository.save(user);

        return convertToDTO(savedBooking);
    }

    public List<BookingResponseDTO> getBookingsByUserId(Long userId) {
        List<Booking> bookings = bookingRepository.findByUserId(userId);
        return bookings.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }

    public List<BookingResponseDTO> getAllBookings() {
        List<Booking> bookings = bookingRepository.findAll();
        return bookings.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private BookingResponseDTO convertToDTO(Booking booking) {
        BookingResponseDTO bookingDTO = new BookingResponseDTO();
        bookingDTO.setId(booking.getId());
        bookingDTO.setCarId(booking.getCar().getId());
        bookingDTO.setUserId(booking.getUser().getId());
        bookingDTO.setBookingStart(booking.getBookingStart());
        bookingDTO.setBookingDate(booking.getBookingDate());
        bookingDTO.setReturnDate(booking.getReturnDate());
        return bookingDTO;
    }

}
