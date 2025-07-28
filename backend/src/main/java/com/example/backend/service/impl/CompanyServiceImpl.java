package com.example.backend.service.impl;

import com.example.backend.model.Company;
import com.example.backend.repository.CompanyRepository;
import com.example.backend.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Company save(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Company updateById(Long id, Company company) {
        Company managedCompany = this.findById(id);
        managedCompany.setCompanyName(company.getCompanyName());
        managedCompany.setCompanyAddress(company.getCompanyAddress());
        return this.save(managedCompany);
    }

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public Company findById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        companyRepository.deleteById(id);
    }
}
