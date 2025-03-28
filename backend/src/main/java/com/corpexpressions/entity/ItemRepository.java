package com.corpexpressions.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    List<Item> findByCompanyCompanyKey(Integer companyKey);
    List<Item> findByContactPersonContactPersonKey(Integer contactPersonKey);
    List<Item> findByDateOfOrderBetween(LocalDate startDate, LocalDate endDate);
    List<Item> findByAwardNameContainingIgnoreCase(String awardName);
}
