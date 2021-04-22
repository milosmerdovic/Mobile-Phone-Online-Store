package com.test.demo.repository;

import java.util.List;

import com.test.demo.entity.Product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository <Product, Integer>{
    Product findById(int id);
    Product findByName(String name);
    List<Product> findAllByOrderByIdAsc();
    Product getOne(Integer id);
    
}