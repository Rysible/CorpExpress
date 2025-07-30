package com.example.backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many orders to one company
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    // Many orders to one contact
    @ManyToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;

    
    private String machineUsed;
    private String awardName;
    private Double shippingCost;
    private Double retailPrice;
    private String previousFileName;
    // One order to many parts
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Part> parts;
}