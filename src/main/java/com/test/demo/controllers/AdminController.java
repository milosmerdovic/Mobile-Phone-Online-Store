package com.test.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.test.demo.entity.Product;
import com.test.demo.repository.ProductRepository;

@Controller
public class AdminController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("/admin")
	public String goToAdminPage(Model model) {
	model.addAttribute("AllProducts", productRepository.findAll());	
		return "admin";
	}
	
	
	
	@GetMapping("/admin/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        Product product = productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        productRepository.delete(product);
        model.addAttribute("AllProducts", productRepository.findAll());
        return "redirect:/admin";
    }
}
