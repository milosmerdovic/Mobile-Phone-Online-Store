package com.test.demo.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.test.demo.entity.Order;
import com.test.demo.entity.OrderItem;
import com.test.demo.entity.Product;
import com.test.demo.repository.OrderItemsRepository;
import com.test.demo.repository.ProductRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class ShoppingCartServiceImpl implements ShoppingCartService{

    private Map<Product, Integer> products = new HashMap<>();
    private List<OrderItem> items = new ArrayList<>();
    @Autowired
    private OrderItemsRepository orderItemsRepository;
    @Autowired
    private ProductRepository productRepository;
    
    @Override
    public List <OrderItem> orderItems(Order order){
    	for(Map.Entry<Product, Integer> entry : products.entrySet()) {
    		OrderItem item = new OrderItem(entry.getKey(), entry.getValue(), order);
    		items.add(item);
    	}
    	orderItemsRepository.saveAll(items);
		return items;
    }
    
    @Override
    public void addProduct(Product product) {
        if (products.containsKey(product)){
            products.replace(product, products.get(product) + 1);
        }else{
            products.put(product, 1);
        }
    }

    @Override
    public void removeProduct(Product product) {
        if (products.containsKey(product)) {
            if (products.get(product) > 1)
                products.replace(product, products.get(product) - 1);
            else if (products.get(product) == 1) {
                products.remove(product);
            }
        }
    }

    @Override
    public Map<Product, Integer> productsInCart() {
        return Collections.unmodifiableMap(products);
    }
    
    
     @Override
     public BigDecimal totalPrice() {
         return products.entrySet().stream()
         .map(entry -> entry.getKey().getPrice().multiply(BigDecimal.valueOf(entry.getValue())))
         .reduce(BigDecimal :: add)
         .orElse(BigDecimal.ZERO);
     }

    @Override
    public void printCart() {
        System.out.println("Broj Artikla " + products.toString());
    }
    
	@Override
	 public void finishOrder(){
	  Product product;
	  for (Map.Entry<Product, Integer> entry : products.entrySet()) {
		  product = productRepository.getById(entry.getKey().getId()); 
	  	  entry.getKey().setQuantity(product.getQuantity() - entry.getValue());
	  }
		  productRepository.saveAll(products.keySet());
		  productRepository.flush();
		  products.clear();
		  items.clear();
	  
	}

	@Override
	public boolean checkStock() {
		for (Map.Entry<Product, Integer> entry : products.entrySet()) {
			Optional<Product> product = productRepository.findById(entry.getKey().getId());
			if(product.get().getQuantity() < entry.getValue()) {
	  		  return false;
			}
		}
		return true;
	}
	@Override
	public void emptyCart() {
		productRepository.flush();
	    products.clear();
	    items.clear();
	}
	
	@Override
	public boolean checkOrder() {
		if(products.isEmpty()) {
			return false;
			}
		return true;
	}

}









