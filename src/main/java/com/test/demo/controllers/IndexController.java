package com.test.demo.controllers;

import com.test.demo.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class IndexController {

    private final ProductRepository productRepository;
    
    
    @Autowired
    public IndexController (ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    @GetMapping({"/","/index","/home"})
    public String home(Model model){
        model.addAttribute("products", productRepository.findAll());
        return "index";
    }
    

}