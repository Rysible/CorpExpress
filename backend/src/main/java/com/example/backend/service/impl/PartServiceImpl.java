package com.example.backend.service.impl;

import com.example.backend.model.Part;
import com.example.backend.repository.PartRepository;
import com.example.backend.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartServiceImpl implements PartService {

    @Autowired
    private PartRepository partRepository;

    @Override
    public Part save(Part part) {
        return partRepository.save(part);
    }

    @Override
    public Part updateById(Long id, Part part) {
        Part managedPart = this.findById(id);
        managedPart.setPartCost(part.getPartCost());
        managedPart.setCompany(part.getCompany());
        return this.save(managedPart);
    }

    @Override
    public List<Part> findAll() {
        return partRepository.findAll();
    }

    @Override
    public Part findById(Long id) {
        return partRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        partRepository.deleteById(id);
    }
}
