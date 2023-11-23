package com.example.RentalCars.service;

import com.example.RentalCars.dto.request.CategoryRequestDTO;
import com.example.RentalCars.dto.response.CategoryResponseDTO;
import com.example.RentalCars.exception.InvalidDataException;
import com.example.RentalCars.exception.ResourceNotFoundException;
import com.example.RentalCars.model.Category;
import com.example.RentalCars.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ModelMapper modelMapper;


    public List<Category> getAllCategories() throws ResourceNotFoundException {
        return categoryRepository.findAll();
    }

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

    public Category saveCategoryById(Long categoryId) throws InvalidDataException {
        Optional<Category> existingCity = categoryRepository.findById(categoryId);

        if (existingCity.isPresent()){
            return existingCity.get();
        }else{
            throw new InvalidDataException("Vai se fuder");
        }

    }
}
