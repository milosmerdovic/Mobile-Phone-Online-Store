package com.test.demo.service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.test.demo.exception.NotEnoughProductsInCartException;
import com.test.demo.entity.Product;

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

    private ProductRepository productRepository;
   
    private Map<Product, Integer> products = new HashMap<>();

    @Autowired
    public ShoppingCartServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
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
    public void checkout(){
        products.clear();
    }
    

}