package com.test.demo.exception;

import com.test.demo.entity.Product;

public class NotEnoughProductsInCartException extends Exception {
    
    private static final String DEFAULT_MESSAGE = "Not enough products in stock";

    public NotEnoughProductsInCartException() {
        super(DEFAULT_MESSAGE);
    }

    public NotEnoughProductsInCartException(Product product) {
        super(String.format("Not enough %s products in stock. Only %d left", product.getName(), product.getQuantity()));
    }
    
}