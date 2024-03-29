package com.test.demo.controllers;

import com.test.demo.entity.Product;
import com.test.demo.service.ProductService;
import com.test.demo.service.ShoppingCartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class ShoppingCartController {
    
    private final ShoppingCartService shoppingCartService;
    private final ProductService productService;
	private static final String NULL_ORDER = "You haven't ordered yet!";
	private static final String NotEnoughProductInStock = "There is not enough products in stock!";

    @Autowired
    public ShoppingCartController(ShoppingCartService shoppingCartService, ProductService productService) {
        this.shoppingCartService = shoppingCartService;
        this.productService = productService;
    }

    @GetMapping("/shoppingCart/addProduct/{id}")
    public String addProductToCart(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        productService.findById(id).ifPresent(shoppingCartService::addProduct);
        boolean result = shoppingCartService.checkStock();
        if(result) {
        	return "redirect:/index";
        }else {	
        redirectAttributes.addFlashAttribute("empty_stock", NotEnoughProductInStock);
        shoppingCartService.emptyCart();
        return "redirect:/index";
        }
    }

    @GetMapping("/shoppingCart/removeProduct/{id}")
    public String removeProductFromCart(@PathVariable("id") Long id) {
        productService.findById(id).ifPresent(shoppingCartService::removeProduct);
        return "redirect:/index";
    }

    @GetMapping("/shoppingCart/checkout")
    public String checkout(Product product, RedirectAttributes redirectAttributes){
    	boolean orderResult = shoppingCartService.checkOrder();
    	if(orderResult) {
    		return "redirect:/order";
    	}else{
    		redirectAttributes.addFlashAttribute("order_message", NULL_ORDER);
    		return "redirect:/index";
    		}
    	}
}