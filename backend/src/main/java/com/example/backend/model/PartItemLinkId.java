package com.example.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Embeddable;
import lombok.Data;
import java.io.Serializable;

@Data
@Embeddable
public class PartItemLinkId implements Serializable {

    private Integer partKey;
    private Integer itemKey;

    // Default constructor
    public PartItemLinkId() {
    }

    public PartItemLinkId(Integer partKey, Integer itemKey) {
        this.partKey = partKey;
        this.itemKey = itemKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        PartItemLinkId that = (PartItemLinkId) o;

        if (partKey != null ? !partKey.equals(that.partKey) : that.partKey != null)
            return false;
        return itemKey != null ? itemKey.equals(that.itemKey) : that.itemKey == null;
    }

    @Override
    public int hashCode() {
        int result = partKey != null ? partKey.hashCode() : 0;
        result = 31 * result + (itemKey != null ? itemKey.hashCode() : 0);
        return result;
    }
}