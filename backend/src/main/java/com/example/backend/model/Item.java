package com.example.backend.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.example.backend.model.Company;
import com.example.backend.model.Contact;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer itemID;

    @ManyToOne
    @JoinColumn(name = "ContactKey")
    private Contact contact;

    @ManyToOne
    @JoinColumn(name = "CompanyKey")
    private Company company;

    @Column
    private LocalDate dateOfOrder;

    @Column(length = 255)
    private String previousFileName;

    @Column(length = 100)
    private String machineUsed;

    @Column(length = 100)
    private String awardName;

    @Column(precision = 10, scale = 2)
    private BigDecimal shippingCost;

    @Column(precision = 10, scale = 2)
    private BigDecimal retailPrice;

    @OneToMany(mappedBy = "item")
    private List<PartItemLink> partItemLinks;
}