package com.example.backend.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.model.Part;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface PartRepository extends JpaRepository<Part, Integer> {
    List<Part> findByPartSupplierContainingIgnoreCase(String supplier);
    List<Part> findByPartCostLessThan(BigDecimal cost);
}
