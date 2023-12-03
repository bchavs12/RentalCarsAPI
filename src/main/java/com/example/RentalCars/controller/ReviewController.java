package com.example.RentalCars.controller;

import com.example.RentalCars.dto.request.ReviewRequestDTO;
import com.example.RentalCars.dto.response.ReviewResponseDTO;
import com.example.RentalCars.exception.InvalidDataException;
import com.example.RentalCars.exception.ResourceNotFoundException;
import com.example.RentalCars.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/all")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
    public ResponseEntity<List<ReviewResponseDTO>> getAllReviews() throws ResourceNotFoundException{
        try{
            List<ReviewResponseDTO> allReviews = reviewService.getAllReviews();
            return new ResponseEntity<>(allReviews, HttpStatus.OK);
        }catch (Exception ex){
            throw new ResourceNotFoundException("Error! Resources not found." + ex);
        }
    }

    @PostMapping("/create")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
    public ResponseEntity<ReviewResponseDTO> createReview(@RequestBody ReviewRequestDTO requestDTO) throws InvalidDataException{
        try{
            ReviewResponseDTO createdReview = reviewService.createReview(requestDTO);
            return new ResponseEntity<>(createdReview, HttpStatus.CREATED);
        }catch (Exception ex){
            throw new InvalidDataException("Resources wasn't updated" + ex);
        }
    }

}
