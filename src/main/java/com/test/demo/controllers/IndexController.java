package com.test.demo.controllers;

import com.test.demo.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    private static Logger logger = LoggerFactory.getLogger(IndexController.class);
    
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    public IndexController (ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    @RequestMapping("/")
    public String showAllProducts(Model model){
        model.addAttribute("products", productRepository.findAll());
        logger.info("Info log message:" + model.getAttribute("products").toString());
        return "/index";
    }
}