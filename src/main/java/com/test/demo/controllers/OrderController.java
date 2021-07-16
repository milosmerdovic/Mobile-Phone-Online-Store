package com.test.demo.controllers;

import com.test.demo.entity.Order;
import com.test.demo.repository.OrderRepository;
import com.test.demo.service.ShoppingCartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class OrderController {
	
	private static final String Order_Message = "Your shipment has been sent";
    
    private ShoppingCartService shoppingCartService;
    @Autowired
    private OrderRepository orderRepository;

    OrderController(ShoppingCartService shoppingCartService){
        this.shoppingCartService = shoppingCartService;
    }
    
    @GetMapping("/order")
    public String orderList(Model model, Order order) {
        model.addAttribute("products", shoppingCartService.productsInCart());
        model.addAttribute("total", shoppingCartService.totalPrice().toString());
        model.addAttribute("order", order); 
        return "order";
    }
    
	  @PostMapping("/createOrder")
	  public String finishOrder(Order order, BindingResult result, RedirectAttributes redirectAttributes){
		  if (result.hasErrors()) {
			  return "redirect:/order"; 
			  }	
		  orderRepository.save(order);
		  order.setOrderItems(shoppingCartService.orderItems(order));
		  shoppingCartService.finishOrder();
		  redirectAttributes.addFlashAttribute("message", Order_Message);
		  return "redirect:/index";
		  }
}