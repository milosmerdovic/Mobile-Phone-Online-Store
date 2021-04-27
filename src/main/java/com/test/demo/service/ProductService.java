package com.test.demo.service;

import java.util.List;

import com.test.demo.entity.Product;

public interface ProductService {

    void save(Product product);
    void edit(Long id, Product product);
    void delete(Long id);
    Product findById(Long id);
    List<Product> findAllByOrderByIdAsc();
    Long count();
}