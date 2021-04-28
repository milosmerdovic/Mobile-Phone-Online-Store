package com.test.demo.controllers;

import com.test.demo.entity.Product;
import com.test.demo.exception.NotEnoughProductsInCartException;
import com.test.demo.service.ProductService;
import com.test.demo.service.ShoppingCartService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShoppingCartController {
    
    private static final Logger logger = LoggerFactory.getLogger(ShoppingCartController.class);
    private final ShoppingCartService shoppingCartService;
    private final ProductService productService;

    @Autowired
    public ShoppingCartController(ShoppingCartService shoppingCartService, ProductService productService) {
        this.shoppingCartService = shoppingCartService;
        this.productService = productService;
    }
    

    @GetMapping("/cart")
    public ModelAndView shoppingCart() {
        ModelAndView modelAndView = new ModelAndView("/cart");
        modelAndView.addObject("products", shoppingCartService.productsInCart());
        return modelAndView;
    }

    @GetMapping("/index/addProduct/{id}")
    public ModelAndView addProductToCart(@PathVariable("id") Long id) {
        productService.findById(id).ifPresent(shoppingCartService::addProduct);
        return shoppingCart();
    }

    @GetMapping("/cart/removeProduct/{id}")
    public ModelAndView removeProductFromCart(@PathVariable("id") Long id) {
        productService.findById(id).ifPresent(shoppingCartService::removeProduct);
        return shoppingCart();
    }

    @GetMapping("/shoppingCart/checkout")
    public ModelAndView checkout() {
        try {
            shoppingCartService.checkout();
        } catch (NotEnoughProductsInCartException e) {
            return shoppingCart().addObject("outOfStockMessage", e.getMessage());
        }
        return shoppingCart();
    }
}