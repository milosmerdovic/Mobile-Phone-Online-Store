package com.test.demo.controllers;

import com.test.demo.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    public Controller (ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    
}