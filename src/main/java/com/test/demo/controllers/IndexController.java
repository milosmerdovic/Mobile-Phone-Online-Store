package com.test.demo.controllers;

import com.test.demo.repository.ProductRepository;
import com.test.demo.service.ShoppingCartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    private final ProductRepository productRepository;
    private ShoppingCartService shoppingCartService;
    
    
    @Autowired
    public IndexController (ProductRepository productRepository, ShoppingCartService shoppingCartService){
        this.shoppingCartService = shoppingCartService;
        this.productRepository = productRepository;
    }
    @GetMapping({"/","/index","/home"})
    public String home(Model model){
        model.addAttribute("allProducts", productRepository.findAll());
        model.addAttribute("products", shoppingCartService.productsInCart());
        model.addAttribute("total", shoppingCartService.totalPrice().toString());
        return "index";
    }
    
    
}