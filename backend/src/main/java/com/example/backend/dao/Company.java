package com.example.backend.dao;

import com.example.backend.model.Item;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer companyKey;

    @Column(length = 255)
    private String companyName;

    @Column(length = 255)
    private String companyAddress;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    @JsonManagedReference // handles parent side of relationship
    private List<Item> items;
}