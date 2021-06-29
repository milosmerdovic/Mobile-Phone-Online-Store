package com.test.demo.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class Order {
	
	@Id
	@GeneratedValue
	private int id;
	
//	@OneToMany
//	private List<OrderItems> orderItems;
	
	@ManyToOne
	private User user;
	
	private Date dateTime;
	
	public Order(){}
	
	public Order(int id, List<OrderItems> orderItems, User user, Date dateTime) {
		this.id = id;
//		this.orderItems = orderItems;
		this.user = user;
		this.dateTime = dateTime;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
//	public List<OrderItems> getOrderItems() {
//		return orderItems;
//	}
//	public void setOrderItems(List<OrderItems> orderItems) {
//		this.orderItems = orderItems;
//	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
