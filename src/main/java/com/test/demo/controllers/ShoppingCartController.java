package com.test.demo.controllers;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.test.demo.entity.Product;
import com.test.demo.entity.ShoppingCart;
import com.test.demo.service.ProductService;
import com.test.demo.service.ProductServiceImpl;
import com.test.demo.service.ShoppingCartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class ShoppingCartController {
    
    private final ShoppingCartService shoppingCartService;
    private final ProductService productService;

    @Autowired
    private ShoppingCart shoppingCart;

    @Autowired
    public ShoppingCartController(ShoppingCartService shoppingCartService, ProductService productService, ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
        this.shoppingCartService = shoppingCartService;
        this.productService = productService;
    }
    

    @GetMapping("/shoppingCart")
    public ModelAndView shoppingCart() {
        ModelAndView modelAndView = new ModelAndView("/shoppingCart");
        modelAndView.addObject("products", shoppingCartService.productsInCart());
        modelAndView.addObject("total", shoppingCartService.totalPrice().toString());
        return modelAndView;
    }

    @GetMapping("/shoppingCart/addProduct/{id}")
    public String addProductToCart(@PathVariable("id") Long id) {
        productService.findById(id).ifPresent(shoppingCartService::addProduct);
        
        return "redirect:/shoppingCart";
    }

    @GetMapping("/shoppingCart/removeProduct/{id}")
    public String removeProductFromCart(@PathVariable("id") Long id) {
        productService.findById(id).ifPresent(shoppingCartService::removeProduct);
        return "redirect:/shoppingCart";
    }

    @GetMapping("/shoppingCart/checkout")
    public String checkout(){
        shoppingCartService.printCart();
        return "redirect:/order";
    }
    
}