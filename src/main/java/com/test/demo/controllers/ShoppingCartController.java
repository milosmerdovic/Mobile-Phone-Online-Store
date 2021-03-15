package com.test.demo.controllers;

import javax.validation.Valid;

import com.test.demo.entity.Product;
import com.test.demo.repository.CartRepository;
import com.test.demo.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ShoppingCartController {

    private final ProductRepository productRepository;
    private final CartRepository cartRepository;

    @Autowired
    public ShoppingCartController(ProductRepository productRepository, CartRepository cartRepository){
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    @GetMapping("/cart")
    public String showCartItems (cartIte){
        model.addAttribute(arg0, arg1);
        return "";
    }
}