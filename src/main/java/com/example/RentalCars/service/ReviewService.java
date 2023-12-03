package com.example.RentalCars.service;

import com.example.RentalCars.dto.request.ReviewRequestDTO;
import com.example.RentalCars.dto.response.ReviewResponseDTO;
import com.example.RentalCars.exception.InvalidDataException;
import com.example.RentalCars.model.Car;
import com.example.RentalCars.model.Review;
import com.example.RentalCars.model.User;
import com.example.RentalCars.repository.CarRepository;
import com.example.RentalCars.repository.ReviewRepository;
import com.example.RentalCars.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final CarRepository carRepository;
    private final UserRepository userRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository, CarRepository carRepository, UserRepository userRepository) {
        this.reviewRepository = reviewRepository;
        this.carRepository = carRepository;
        this.userRepository = userRepository;
    }

    public ReviewResponseDTO createReview(ReviewRequestDTO reviewDTO) throws InvalidDataException {
        Review review = new Review();
        review.setRating(reviewDTO.getRating());
        review.setComment(reviewDTO.getComment());

        Car car = carRepository.findById(reviewDTO.getCarId())
                .orElseThrow(() -> new InvalidDataException("Car not found with id: " + reviewDTO.getCarId()));
        review.setCar(car);

        User user = userRepository.findById(reviewDTO.getUserId())
                .orElseThrow(() -> new InvalidDataException("User not found with id: " + reviewDTO.getUserId()));
        review.setUser(user);

        Review savedReview = reviewRepository.save(review);

        return convertToDTO(savedReview);
    }

    public List<ReviewResponseDTO> getAllReviews() {
        List<Review> reviews = reviewRepository.findAll();
        return reviews.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private ReviewResponseDTO convertToDTO(Review review) {
        ReviewResponseDTO reviewDTO = new ReviewResponseDTO();
        reviewDTO.setId(review.getId());
        reviewDTO.setRating(review.getRating());
        reviewDTO.setComment(review.getComment());
        reviewDTO.setCarId(review.getCar().getId());
        reviewDTO.setUserId(review.getUser().getId());
        return reviewDTO;
    }

}
