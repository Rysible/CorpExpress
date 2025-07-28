package com.example.backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Part {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "company_id") // company_id in Part table
    private Company company;
    private Double partCost;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}