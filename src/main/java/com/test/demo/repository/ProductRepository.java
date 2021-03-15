package com.test.demo.repository;

import com.test.demo.entity.Product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository <Product, Integer>{
    
    void addProduct(Product product);
    void removeProduct(Product product);
    
}