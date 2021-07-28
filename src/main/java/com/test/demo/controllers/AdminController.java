package com.test.demo.controllers;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.servlet.view.RedirectView;

import com.test.demo.entity.Order;
import com.test.demo.entity.Product;
import com.test.demo.repository.OrderRepository;
import com.test.demo.repository.ProductRepository;
import com.test.demo.upload.FileUpload;

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
    public ResponseEntity addItem(@Valid Product product, BindingResult result,@RequestParam("file") MultipartFile file){
        if (result.hasErrors()) {
            return ResponseEntity.ok("admin/add-item");
        }
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        product.setPhotos(fileName);
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
			.path("images/")
			.path(fileName).path("/add-item")
			.toUriString();
        productRepository.save(product);
        return ResponseEntity.ok(fileDownloadUri);
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
