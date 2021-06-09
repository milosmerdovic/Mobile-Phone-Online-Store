package com.test.demo.service;

import java.math.BigDecimal;
import java.util.Map;

import com.test.demo.entity.Product;
import com.test.demo.exception.NotEnoughProductsInCartException;

public interface ShoppingCartService {

    void addProduct(Product product);
    void removeProduct(Product product);
    Map <Product, Integer> productsInCart();
    BigDecimal totalPrice();
    void checkout() throws NotEnoughProductsInCartException;
}