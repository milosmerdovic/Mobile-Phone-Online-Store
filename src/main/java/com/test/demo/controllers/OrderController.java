package com.test.demo.controllers;

import com.test.demo.entity.Order;
import com.test.demo.entity.OrderItem;
import com.test.demo.repository.OrderRepository;
import com.test.demo.service.ShoppingCartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrderController {
    
    private ShoppingCartService shoppingCartService;
    @Autowired
    private OrderRepository orderRepository;

    OrderController(ShoppingCartService shoppingCartService){
        this.shoppingCartService = shoppingCartService;
    }
    
    @GetMapping("/order")
    public String orderList(Model model, Order order, OrderItem orderItems) {
        model.addAttribute("products", shoppingCartService.productsInCart());
        model.addAttribute("total", shoppingCartService.totalPrice().toString());
        order.setOrderItems(shoppingCartService.orderItems());
        model.addAttribute("order", order);
        return "order";
    }
    
	  @PostMapping("/createOrder") 
	  public String order(Order order, BindingResult result) {
		  if (result.hasErrors()) {
			  return "redirect:/order"; 
			  }
		  orderRepository.save(order);
		  System.out.println("Order sent");
		  shoppingCartService.clearList();
		  return "redirect:/index";
		  }
}
