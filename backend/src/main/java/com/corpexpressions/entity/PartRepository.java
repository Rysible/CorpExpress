package com.corpexpressions.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface PartRepository extends JpaRepository<Part, Integer> {
    List<Part> findByPartSupplierContainingIgnoreCase(String supplier);
    List<Part> findByPartCostLessThan(BigDecimal cost);
}
