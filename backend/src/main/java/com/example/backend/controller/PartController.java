package com.example.backend.controller;

import com.example.backend.model.Part;
import com.example.backend.model.Company;
import com.example.backend.repository.CompanyRepository;
import com.example.backend.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parts")
public class PartController {

    @Autowired
    private PartService partService;

    @Autowired
    private CompanyRepository companyRepository;

    @PostMapping
    public Part save(@RequestBody Part part) {
        if (part.getCompany() != null && part.getCompany().getId() != null) {
            Company company = companyRepository.findById(part.getCompany().getId())
                    .orElseThrow(() -> new RuntimeException("Company not found"));
            part.setCompany(company);
        }
        return partService.save(part);
    }

    @GetMapping
    public List<Part> findAll() {
        return partService.findAll();
    }

    @GetMapping("/{id}")
    public Part findById(@PathVariable Long id) {
        return partService.findById(id);
    }

    @PutMapping("/{id}")
    public Part update(@PathVariable Long id, @RequestBody Part part) {
        return partService.updateById(id, part);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        partService.deleteById(id);
    }
}
