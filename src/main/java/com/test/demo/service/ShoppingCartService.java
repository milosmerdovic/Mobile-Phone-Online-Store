package com.test.demo.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.test.demo.entity.Product;

public interface ShoppingCartService {

    void addProduct(Product product);
    void removeProduct(Product product);
    Map <Product, Integer> productsInCart();
    List<Product> orderedProducts();
    BigDecimal totalPrice();
    void printCart();
}