package com.example.backend.service;

import com.example.backend.model.Company;

import java.util.List;

public interface CompanyService {
    Company save(Company company);

    List<Company> findAll();

    Company findById(Long id);

    void deleteById(Long id);
}
