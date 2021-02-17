package com.warehouse.ladaparts.repository;

import com.warehouse.ladaparts.enteties.ModelsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<ModelsEntity,Integer> {
}
