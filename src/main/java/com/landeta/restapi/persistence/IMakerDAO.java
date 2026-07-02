package com.landeta.restapi.persistence;

import com.landeta.restapi.entities.Maker;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface IMakerDAO {

    List<Maker> findAll();

    Optional<Maker> findById(Long id);

    void save(Maker maker);

    void deleteById(Long id);

}
