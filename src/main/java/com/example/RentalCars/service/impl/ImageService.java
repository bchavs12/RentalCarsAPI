package com.example.RentalCars.service.impl;

import com.example.RentalCars.dto.request.ImageRequestDTO;
import com.example.RentalCars.dto.response.ImageResponseDTO;
import com.example.RentalCars.model.ImageUrl;
import com.example.RentalCars.service.IImage;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.List;

public class ImageService implements IImage<ImageUrl, ImageRequestDTO, ImageResponseDTO> {
    @Override
    public List<ImageUrl> getAllImages() throws SQLException {
        return null;
    }

    @Override
    public ImageResponseDTO saveImage(ImageRequestDTO requestDTO) throws SQLDataException {
        return null;
    }
}
