package com.test.demo.controllers;

import java.security.Principal;
import java.util.Optional;

import com.test.demo.entity.Product;
import com.test.demo.repository.ProductRepository;
import com.test.demo.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


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

    @GetMapping("/login")
    public String login(Principal principal) {
        if (principal != null) {
            return "redirect:/home";
        }
        return "/login";
    }
    
    @GetMapping("/register")
    public String register() {
        return "register";
    }
    
}