package com.warehouse.ladaparts.repository;

import com.warehouse.ladaparts.enteties.PartsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartsRepository  extends JpaRepository<PartsEntity,Integer> {

}
