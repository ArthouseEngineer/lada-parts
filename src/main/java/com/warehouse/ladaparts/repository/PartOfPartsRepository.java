package com.warehouse.ladaparts.repository;

import com.warehouse.ladaparts.enteties.PartOfPartsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartOfPartsRepository extends JpaRepository<PartOfPartsEntity, Integer> {
}
