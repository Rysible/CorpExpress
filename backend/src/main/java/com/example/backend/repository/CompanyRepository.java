// CompanyRepository.java
package com.example.backend.model;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
    Optional<Company> findByCompanyNameIgnoreCase(String companyName);
    List<Company> findByCompanyNameContainingIgnoreCase(String companyName);
}