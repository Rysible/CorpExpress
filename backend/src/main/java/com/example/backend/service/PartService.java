package com.example.backend.service;

import com.example.backend.model.Part;

import java.util.List;

public interface PartService {
    Part save(Part part);

    Part updateById(Long id, Part part);

    List<Part> findAll();

    Part findById(Long id);

    void deleteById(Long id);
}
