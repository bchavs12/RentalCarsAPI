package com.example.RentalCars.service.impl;

import com.example.RentalCars.dto.request.CategoryRequestDTO;
import com.example.RentalCars.dto.response.CategoryResponseDTO;
import com.example.RentalCars.exception.InvalidDataException;
import com.example.RentalCars.exception.ResourceNotFoundException;
import com.example.RentalCars.model.Category;
import com.example.RentalCars.repository.CategoryRepository;
import com.example.RentalCars.service.ICategory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.List;
@Service
public class CategoryService implements ICategory<Category, CategoryRequestDTO, CategoryResponseDTO> {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Category> getAllCategories() throws ResourceNotFoundException {
        return categoryRepository.findAll();
    }

    @Override
    public CategoryResponseDTO createCategory(CategoryRequestDTO requestDTO) throws InvalidDataException {
        try{
            Category category = modelMapper.map(requestDTO, Category.class);
            Category savedCategory = categoryRepository.save(category);
            CategoryResponseDTO categoryResponseDTO = modelMapper.map(savedCategory, CategoryResponseDTO.class);
            return categoryResponseDTO;
        }catch (Exception ex){
            throw new InvalidDataException("Erro! Dados incorretos");
        }
    }
}
