package com.corpexpressions.entity;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartItemLinkRepository extends JpaRepository<PartItemLink, PartItemLinkId> {
List<PartItemLink> findByItemItemID(Integer itemId);
List<PartItemLink> findByPartPartKey(Integer partKey);
void deleteByItemItemID(Integer itemId);
}
