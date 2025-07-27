package com.example.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.model.Item;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    List<Item> findByCompanyCompanyKey(Integer companyKey);
    List<Item> findByContactPersonContactPersonKey(Integer contactPersonKey);
    List<Item> findByDateOfOrderBetween(LocalDate startDate, LocalDate endDate);
    List<Item> findByAwardNameContainingIgnoreCase(String awardName);
}
