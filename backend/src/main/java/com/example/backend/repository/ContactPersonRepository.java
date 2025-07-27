package com.example.backend.repository;
// ContactPersonRepository.java


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.dao.ContactPerson;

@Repository
public interface ContactPersonRepository extends JpaRepository<ContactPerson, Integer> {
    List<ContactPerson> findByLastNameContainingIgnoreCase(String lastName);
    List<ContactPerson> findByEmailAddressContainingIgnoreCase(String email);
}