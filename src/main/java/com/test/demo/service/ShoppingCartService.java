package com.test.demo.service;

import java.math.BigDecimal;
import java.util.Map;

import com.test.demo.entity.Product;

public interface ShoppingCartService {

    void addProduct(Product product);
    void removeProduct(Product product);
    void clearProducts();
    Map <Product, Long> productsInCart();
    BigDecimal totalPrice();
    void checkout();
}