package com.example.RentalCars.service.impl;

import com.example.RentalCars.dto.request.CategoryRequestDTO;
import com.example.RentalCars.dto.response.CategoryResponseDTO;
import com.example.RentalCars.model.Category;
import com.example.RentalCars.service.ICategory;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.List;
public class CategoryService implements ICategory<Category, CategoryRequestDTO, CategoryResponseDTO> {



    @Override
    public List<Category> getAllCategories() throws SQLException {
        return null;
    }

    @Override
    public CategoryResponseDTO createCategory(CategoryRequestDTO requestDTO) throws SQLDataException {
        return null;
    }
}
