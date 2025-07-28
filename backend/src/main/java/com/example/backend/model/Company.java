package com.example.backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;
    private String companyAddress;

    @OneToMany(mappedBy = "company")
    private List<Order> orders;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Part> parts;
}