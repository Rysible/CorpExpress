package com.corpexpressions.entity;
// ContactPersonRepository.java


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactPersonRepository extends JpaRepository<ContactPerson, Integer> {
    List<ContactPerson> findByLastNameContainingIgnoreCase(String lastName);
    List<ContactPerson> findByEmailAddressContainingIgnoreCase(String email);
}