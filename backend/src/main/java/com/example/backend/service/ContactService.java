package com.example.backend.service;

import com.example.backend.model.Contact;

import java.util.List;

public interface ContactService {
    Contact save(Contact contact);

    Contact updateById(Long id, Contact contact);

    List<Contact> findAll();

    Contact findById(Long id);

    void deleteById(Long id);
}
