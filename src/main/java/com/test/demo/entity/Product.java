package com.test.demo.entity;

import java.math.BigDecimal;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;
    
    @Column(name = "price")
    @DecimalMin(value = "0.00", message = "*Price has to be non negative number")
    private BigDecimal price;
    
    @Column(name = "quantity")
    @Min(value = 0, message = "*Quantity has to be non negative number")
    private Integer quantity;
    
    @Column(nullable = true, length = 64)
    private String photos;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
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
    
    public String getPhotos() {
        return photos;
    }
    public void setPhotos(String photos) {
        this.photos = photos;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
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
    @Transient
    public String getPhotosImagePath() {
        if (photos == null || id == null) return null;
         
        return "images/" + photos;
    }
}