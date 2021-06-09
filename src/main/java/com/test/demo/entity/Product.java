package com.test.demo.entity;

import java.math.BigDecimal;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;
    
    @Column(name = "price", nullable = false)
    @DecimalMin(value = "0.00", message = "*Price has to be non negative number")
    private BigDecimal price;
    
    @Column(name = "quantity", nullable = false)
    @Min(value = 0, message = "*Quantity has to be non negative number")
    private Integer quantity;

    private String path;
    

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return id.equals(product.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}