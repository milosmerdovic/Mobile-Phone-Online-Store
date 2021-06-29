package com.test.demo.controllers;

import com.test.demo.service.ProductService;
import com.test.demo.service.ShoppingCartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class ShoppingCartController {
    
    private final ShoppingCartService shoppingCartService;
    private final ProductService productService;


    @Autowired
    public ShoppingCartController(ShoppingCartService shoppingCartService, ProductService productService) {
        this.shoppingCartService = shoppingCartService;
        this.productService = productService;
    }

    
/* 
    @GetMapping("/shoppingCart")
    public ModelAndView shoppingCart() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("products", shoppingCartService.productsInCart());
        modelAndView.addObject("total", shoppingCartService.totalPrice().toString());
        modelAndView.setViewName("fragments/shoppingCart");
        return modelAndView;
    }
 */
    @GetMapping("/shoppingCart/addProduct/{id}")
    public String addProductToCart(@PathVariable("id") Long id) {
        productService.findById(id).ifPresent(shoppingCartService::addProduct);
        return "redirect:/index";
    }

    @GetMapping("/shoppingCart/removeProduct/{id}")
    public String removeProductFromCart(@PathVariable("id") Long id) {
        productService.findById(id).ifPresent(shoppingCartService::removeProduct);
        return "redirect:/index";
    }

    @GetMapping("/shoppingCart/checkout")
    public String checkout(){
        shoppingCartService.printCart();
        return "redirect:/order";
    }
    
}