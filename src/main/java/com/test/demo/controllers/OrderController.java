package com.test.demo.controllers;

import com.test.demo.service.ShoppingCartService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrderController {
    
    ShoppingCartService shoppingCartService;

    OrderController(ShoppingCartService shoppingCartService){
        this.shoppingCartService=shoppingCartService;
    }

    @GetMapping("/order")
    public ModelAndView orderList() {
        ModelAndView mav = new ModelAndView("/order");
        mav.addObject("products", shoppingCartService.productsInCart());
        mav.addObject("total", shoppingCartService.totalPrice().toString());
        return mav;
    }


}
