package com.example.backend.dao;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
import com.example.backend.model.Item;

@Data
@Entity
@Table(name = "ContactPerson")
public class ContactPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer contactPersonKey;

    @Column(length = 100)
    private String firstName;

    @Column(length = 100)
    private String lastName;

    @Column(length = 50)
    private String title;

    @Column(length = 255)
    private String emailAddress;

    @Column(length = 20)
    private String phoneNumber;

    @OneToMany(mappedBy = "contactPerson", cascade = CascadeType.ALL)
    private List<Item> items;
}