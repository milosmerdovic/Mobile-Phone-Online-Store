package com.test.demo.entity;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class ShoppingCart {

    @Id
    @GeneratedValue
    private int id;

    private int quantity;
    
    @OneToMany
    List <Product> products;

    public ShoppingCart() {
    }

    public ShoppingCart(int id, int quantity, List<Product> products) {
        this.id = id;
        this.quantity = quantity;
        this.products = products;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public ShoppingCart id(int id) {
        setId(id);
        return this;
    }

    public ShoppingCart quantity(int quantity) {
        setQuantity(quantity);
        return this;
    }

    public ShoppingCart products(List<Product> products) {
        setProducts(products);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ShoppingCart)) {
            return false;
        }
        ShoppingCart shoppingCart = (ShoppingCart) o;
        return id == shoppingCart.id && quantity == shoppingCart.quantity && Objects.equals(products, shoppingCart.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantity, products);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", quantity='" + getQuantity() + "'" +
            ", products='" + getProducts() + "'" +
            "}";
    }

}
