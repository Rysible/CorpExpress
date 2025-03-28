package com.corpexpressions.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "Part")
public class Part {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer partKey;

    @Column(precision = 10, scale = 2)
    private BigDecimal partCost;

    @Column(length = 255)
    private String partSupplier;

    @OneToMany(mappedBy = "part")
    private List<PartItemLink> partItemLinks;
}