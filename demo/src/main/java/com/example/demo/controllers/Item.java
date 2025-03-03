
package cmanagment.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "Item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer itemID;

    @ManyToOne
    @JoinColumn(name = "ContactPersonKey")
    private ContactPerson contactPerson;

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