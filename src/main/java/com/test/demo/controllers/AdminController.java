package com.test.demo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.demo.entity.Order;
import com.test.demo.entity.Product;
import com.test.demo.repository.OrderRepository;
import com.test.demo.repository.ProductRepository;

@Controller
public class AdminController {
	
	private final ProductRepository productRepository;
	private final OrderRepository orderRepository;
	
	@Autowired
	public AdminController(ProductRepository productRepository, OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
		this.productRepository = productRepository;
	}
	
	@GetMapping("/admin")
	public String goToAdminPage(Model model) {
	model.addAttribute("AllProducts", productRepository.findAll());	
		return "admin/admin";
	}
	
	@GetMapping("/admin/back")
	public String goBackButton() {
		return "redirect:/admin";
	}
	
	@GetMapping("/admin/add-item")
	public String showAddItemForm(Product product) {
		return "admin/add-item";
	}
	
    @PostMapping("/add-item")
    public String addUser(@Valid Product product, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "admin/add-item";
        }
        productRepository.save(product);
        model.addAttribute("AllProducts", productRepository.findAll());
        return "redirect:/admin";
    }
	
    @GetMapping("/admin/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Product product = productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("product", product);
        return "admin/update";
    }
    
    @PostMapping("/admin/update/{id}")
    public String updateProduct(@PathVariable("id") long id, @Valid Product product, BindingResult result, Model model) {
        if (result.hasErrors()) {
            product.setId(id);
            return "admin/update";
        }
        productRepository.save(product);
        model.addAttribute("AllProducts", productRepository.findAll());
        return "redirect:/admin";
    }
	
	@GetMapping("/admin/delete/{id}")
    public String deleteProduct(@PathVariable("id") long id, Model model) {
        Product product = productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        productRepository.delete(product);
        model.addAttribute("AllProducts", productRepository.findAll());
        return "redirect:/admin";
    }
	
	@GetMapping("/admin/orders")
	public String showOrders(Model model, Order order) {
		model.addAttribute("orders", orderRepository.findAll());
		return "admin/orders";
	}
	
}
