package com.test.demo.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OrderItems {
	
	@Id
	@GeneratedValue
	private int id;
	
	@ManyToOne
	private Product unitProduct;
	
	@ManyToOne
	@JoinColumn(name="order_id")
	private Order order;
	
	private BigDecimal quantity;
	private BigDecimal amount;
	
	public OrderItems() {}

	public OrderItems(int id, Product unitProduct, Order order, BigDecimal quantity, BigDecimal amount) {
		super();
		this.id = id;
		this.unitProduct = unitProduct;
		this.order = order;
		this.quantity = quantity;
		this.amount = amount;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Product getUnitProduct() {
		return unitProduct;
	}

	public void setUnitProduct(Product unitProduct) {
		this.unitProduct = unitProduct;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	
	public BigDecimal totalPriceOfItems() {
		return amount = this.unitProduct.getPrice().multiply(quantity);
	}
}
