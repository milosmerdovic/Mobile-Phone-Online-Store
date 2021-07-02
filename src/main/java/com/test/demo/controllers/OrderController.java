package com.test.demo.controllers;

import com.test.demo.entity.Order;
import com.test.demo.repository.OrderRepository;
import com.test.demo.service.ShoppingCartService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrderController {
    
    private ShoppingCartService shoppingCartService;
    private OrderRepository orderRepository;

    OrderController(ShoppingCartService shoppingCartService, OrderRepository orderRepository){
        this.shoppingCartService=shoppingCartService;
        this.orderRepository = orderRepository;
    }

    @GetMapping("/order")
    public String orderList(Model model, Order order) {
        model.addAttribute("products", shoppingCartService.productsInCart());
        model.addAttribute("total", shoppingCartService.totalPrice().toString());
        order.setOrderItems(shoppingCartService.productsForOrders());
        model.addAttribute("order", order);
        return "order";
    }
    
	  @PostMapping("/createOrder") 
	  public String order(@ModelAttribute Order order, BindingResult result) {
		  if (result.hasErrors()) {
			  return "redirect:/order"; 
			  }
		  orderRepository.save(order);
		  /*
		   * orderService.finishOrder();
		   */
		  System.out.println("Order sent");
		  return "redirect:/index";
		  }

}
