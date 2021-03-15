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
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView shoppingCart() {
        ModelAndView modelAndView = new ModelAndView("/cart");
        modelAndView.addObject("products", cartRepository.getProductsInCart());
        modelAndView.addObject("total", cartRepository.getTotal().toString());
        return modelAndView;
    }
    @GetMapping("/cart/addProduct/{productId}")
    public ModelAndView addProductToCart(@PathVariable("productId") Long productId) {
        productRepository.findById().ifPresent(cartRepository::addProduct);
        return shoppingCart();
    }

}