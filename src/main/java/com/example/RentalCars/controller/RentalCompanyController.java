package com.example.RentalCars.controller;

import com.example.RentalCars.dto.request.RentalCompanyRequestDTO;
import com.example.RentalCars.dto.response.RentalCompanyResponseDTO;
import com.example.RentalCars.exception.InvalidDataException;
import com.example.RentalCars.exception.ResourceNotFoundException;
import com.example.RentalCars.model.RentalCompany;
import com.example.RentalCars.service.RentalCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
public class RentalCompanyController {

    @Autowired
    private RentalCompanyService rentalCompanyService;

    @GetMapping
    public ResponseEntity<List<RentalCompany>> getAllCompanies() throws ResourceNotFoundException {
        List<RentalCompany> companyList = rentalCompanyService.getAllRentalCompany();

        if (!companyList.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(companyList);
        }else{
            throw new ResourceNotFoundException("Erro! registro não encontrado");
        }

    }
    @GetMapping("/city/{city}")
        public ResponseEntity<List <RentalCompany>> getRentalCompanyByCity(@PathVariable Long city){
        List<RentalCompany> rentalCompanies = rentalCompanyService.getRentalCompaniesByCity(city);
        if (rentalCompanies.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(rentalCompanies);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<RentalCompanyResponseDTO> createCompany(@RequestBody RentalCompanyRequestDTO requestDTO) throws InvalidDataException{
        try{
            RentalCompanyResponseDTO responseDTO = rentalCompanyService.createRentalCompany(requestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
        }catch (Exception ex){
            throw new InvalidDataException("Informe todo os dados validos");
        }
    }

}
