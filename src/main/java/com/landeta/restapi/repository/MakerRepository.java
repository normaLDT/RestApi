package com.landeta.restapi.repository;

import com.landeta.restapi.entities.Maker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MakerRepository extends CrudRepository<Maker,Long> {

}
