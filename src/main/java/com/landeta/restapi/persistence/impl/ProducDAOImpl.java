package com.landeta.restapi.persistence.impl;

import com.landeta.restapi.entities.Product;
import com.landeta.restapi.persistence.IProductDAO;
import com.landeta.restapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Component
public class ProducDAOImpl implements IProductDAO {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice) {
        return productRepository.findProductByPriceBetween(minPrice,maxPrice);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);

    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);

    }
}
