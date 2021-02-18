package com.warehouse.ladaparts.repository;

import com.warehouse.ladaparts.enteties.AutoMarkPartsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoMarkPartsRepository  extends JpaRepository<AutoMarkPartsEntity, Integer> {
}
