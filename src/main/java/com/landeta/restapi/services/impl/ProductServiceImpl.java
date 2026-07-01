package com.landeta.restapi.services.impl;

import com.landeta.restapi.entities.Product;
import com.landeta.restapi.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    IProductService productService;

    @Override
    public List<Product> findAll() {
        return productService.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productService.findById(id);
    }

    @Override
    public List<Product> findByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice) {
        return productService.findByPriceInRange(minPrice,maxPrice);
    }

    @Override
    public void save(Product product) {

        productService.save(product);

    }

    @Override
    public void deleteById(Long id) {
        productService.deleteById(id);

    }
}
