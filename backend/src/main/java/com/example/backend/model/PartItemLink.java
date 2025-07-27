
package com.example.backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "PartItemLink")
public class PartItemLink {

    @EmbeddedId
    private PartItemLinkId id;

    @ManyToOne
    @MapsId("partKey")
    @JoinColumn(name = "PartKey")
    private Part part;

    @ManyToOne
    @MapsId("itemKey")
    @JoinColumn(name = "ItemKey")
    private Item item;

    @Column
    private Integer partQuantity;
}