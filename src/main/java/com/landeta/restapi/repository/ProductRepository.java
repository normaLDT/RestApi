package com.landeta.restapi.repository;

import com.landeta.restapi.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query("SELECT p from Product where p.price between ?1 AND ?2")
    List<Product> findProductByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice);

    List<Product> findProductByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);


}
