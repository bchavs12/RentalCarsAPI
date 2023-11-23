package com.example.RentalCars.controller;

import com.example.RentalCars.dto.request.CategoryRequestDTO;
import com.example.RentalCars.dto.response.CategoryResponseDTO;
import com.example.RentalCars.exception.InvalidDataException;
import com.example.RentalCars.exception.ResourceNotFoundException;
import com.example.RentalCars.model.Category;
import com.example.RentalCars.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() throws ResourceNotFoundException {
        List<Category> categoryList = categoryService.getAllCategories();

        if (!categoryList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(categoryList);
        } else {
            throw new ResourceNotFoundException("Erro! registro não encontrado");
        }
    }


    @PostMapping
    public ResponseEntity<CategoryResponseDTO> createCategory(@RequestBody CategoryRequestDTO requestDTO) throws InvalidDataException {
        try {
            CategoryResponseDTO responseDTO = categoryService.createCategory(requestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
        } catch (Exception ex) {
            throw new InvalidDataException("Informe todos os dados validos");
        }
    }

}
