package com.test.demo.repository;

import java.util.Optional;

import com.test.demo.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findById(Long id);
    
}