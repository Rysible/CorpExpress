package com.corpexpressions.dao;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

import com.corpexpressions.entity.Item;

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
    private List<Item> items;
}