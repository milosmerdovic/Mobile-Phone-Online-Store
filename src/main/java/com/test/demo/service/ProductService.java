package com.test.demo.service;

import java.util.Optional;

import com.test.demo.entity.Product;

public interface ProductService {

    Optional <Product> findById(Long id);
}