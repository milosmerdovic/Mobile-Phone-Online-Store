package com.test.demo.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="TABLE_ORDER")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
	private int id;
	@OneToMany
	private List<Product> orderProduct;
	@NotNull(message = "This field is mandatory!")	
	private String customerName, customerLastName, customerAddress;
	@Email(message = "Please enter a valid email address!")
	@NotNull(message="This field is mandatory!")
	private String customerEmail;
	private LocalDateTime createdAt = LocalDateTime.now();

	public Order(){}
	
	public Order(int id, List<Product> orderProduct, LocalDateTime createdAt) {
		this.createdAt = createdAt;
		this.id = id;
		this.orderProduct = orderProduct;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerLastName() {
		return customerLastName;
	}
	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public void setOrderProduct(List<Product> orderProduct) {
		this.orderProduct = orderProduct;
	}
	public List<Product> getOrderProduct() {
		return orderProduct;
	}


	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
}
