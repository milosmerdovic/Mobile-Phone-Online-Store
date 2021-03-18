package com.test.demo.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.test.demo.entity.CartItem;
import com.test.demo.entity.Product;
import com.test.demo.entity.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends CrudRepository <CartItem, Integer> {
    
    // public List <CartItem> findByUser(User user);
    // public Map <Product, Integer> getProductsInCart();
    // public void addProduct(Product product);
    // public void removeProduct(Product product);
    // BigDecimal getTotal();
    
          
}