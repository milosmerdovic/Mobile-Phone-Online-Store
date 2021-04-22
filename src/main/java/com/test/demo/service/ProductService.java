package com.test.demo.service;

import java.util.List;

import com.test.demo.entity.Product;

public interface ProductService {

    void save(Product product);
    void edit(int id, Product newProduct);
    void delete(int id);
    Product findById(int id);
    List<Product> findAllByOrderByIdAsc();
    Integer count();
}