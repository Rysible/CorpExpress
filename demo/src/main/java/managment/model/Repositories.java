// ContactPersonRepository.java

/* 
package management.model;

 import com.example.ordermanagement.model.ContactPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactPersonRepository extends JpaRepository<ContactPerson, Integer> {
    List<ContactPerson> findByLastNameContainingIgnoreCase(String lastName);
    List<ContactPerson> findByEmailAddressContainingIgnoreCase(String email);
}

// CompanyRepository.java
package com.example.ordermanagement.repository;

        import com.example.ordermanagement.model.Company;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;

        import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
    Optional<Company> findByCompanyNameIgnoreCase(String companyName);
    List<Company> findByCompanyNameContainingIgnoreCase(String companyName);
}

// ItemRepository.java
package com.example.ordermanagement.repository;

        import com.example.ordermanagement.model.Item;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;

        import java.time.LocalDate;
        import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    List<Item> findByCompanyCompanyKey(Integer companyKey);
    List<Item> findByContactPersonContactPersonKey(Integer contactPersonKey);
    List<Item> findByDateOfOrderBetween(LocalDate startDate, LocalDate endDate);
    List<Item> findByAwardNameContainingIgnoreCase(String awardName);
}

// PartRepository.java
package com.example.ordermanagement.repository;

        import com.example.ordermanagement.model.Part;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;

        import java.math.BigDecimal;
        import java.util.List;

@Repository
public interface PartRepository extends JpaRepository<Part, Integer> {
    List<Part> findByPartSupplierContainingIgnoreCase(String supplier);
    List<Part> findByPartCostLessThan(BigDecimal cost);
}

// PartItemLinkRepository.java
package managment.model;

        import com.example.ordermanagement.model.PartItemLink;
        import com.example.ordermanagement.model.PartItemLinkId;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;

        import java.util.List;

@Repository
public interface PartItemLinkRepository extends JpaRepository<PartItemLink, PartItemLinkId> {
    List<PartItemLink> findByItemItemID(Integer itemId);
    List<PartItemLink> findByPartPartKey(Integer partKey);
    void deleteByItemItemID(Integer itemId);
}
*/