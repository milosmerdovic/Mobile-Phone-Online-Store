package com.test.demo.service;


import java.util.Optional;

import com.test.demo.entity.Product;
import com.test.demo.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }
    
}