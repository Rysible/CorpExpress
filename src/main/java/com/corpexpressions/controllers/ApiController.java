package com.corpexpressions.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import com.corpexpressions.dao.Company;
import com.corpexpressions.entity.CompanyRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000") // allow React frontend
public class ApiController {

    private final CompanyRepository companyRepository;

    public ApiController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @GetMapping("/companies")
    public ResponseEntity<List<Company>> getCompanies() {
        List<Company> companies = companyRepository.findAll();
        return ResponseEntity.ok(companies);
    }

    // TODO add more endpoints for other objects.
}