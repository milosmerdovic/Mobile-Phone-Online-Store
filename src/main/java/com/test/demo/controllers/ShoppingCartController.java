package com.test.demo.controllers;

import com.test.demo.entity.Product;
import com.test.demo.repository.CartRepository;
import com.test.demo.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    @GetMapping("/index/addToShoppingCart/{id}")
    public String addProduct(@PathVariable("id") int id){
        productRepository.findById(id).ifPresent(cartRepository::addProduct);
        return "/index";
    }
    // @GetMapping("/cart")
    // public ModelAndView shoppingCart() {
    //     ModelAndView modelAndView = new ModelAndView("/cart");
    //     modelAndView.addObject("products", cartRepository.getProductsInCart());
    //     modelAndView.addObject("total", cartRepository.getTotal().toString());
    //     return modelAndView;
    // }
    // @GetMapping("/addProduct/{productid}")
    // public ModelAndView addProductToCart(@PathVariable("productid") int productid) {
    //     productRepository.findById(productid).ifPresent(cartRepository::addProduct);
    //     return "";
    // }
    // @GetMapping("/cart/removeProduct/{productId}")
    // public ModelAndView removeProductFromCart(@PathVariable("productId") int productid) {
    //     productRepository.findById(productid).ifPresent(cartRepository::removeProduct);
    //     return shoppingCart();
    // }

}