package com.test.demo.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
	private int id;
	
	@NotNull(message = "This field is mandatory!")
    @Column(name = "name", nullable = false)
	private String customerName;
	
	@Column(name = "last_name", nullable = false)
	private String customerLastName;
	
	@Column(name = "address", nullable = false)
	private String customerAddress;
	
	@Email(message = "Please enter a valid email address!")
	@NotNull(message="This field is mandatory!")
	@Column(name = "email", nullable = false)
	private String customerEmail;
	
	private BigDecimal total;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@Column(name = "created_at")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime createdAt = LocalDateTime.now();

	@Column(name = "sent")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime sent;

	@Column(name = "returned")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime returned;
	
	@Column(name = "finished")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime finished;
	
	@Column(name = "canceled")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime canceled;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "order", fetch = FetchType.LAZY)
	private List<OrderItem> orderItems;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
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
	
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	
	public Status getStatus() {
		return this.status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public LocalDateTime getSent() {
		return this.sent;
	}
	public void setSent(LocalDateTime sent) {
		this.sent = sent;
	}
	
	public LocalDateTime getReturned() {
		return this.returned;
	}
	public void setReturned(LocalDateTime returned) {
		this.returned = returned;
	}
	
	public LocalDateTime getFinished() {
		return this.finished;
	}
	public void setFinished(LocalDateTime finished) {
		this.finished = finished;
	}
	
	public LocalDateTime getCanceled() {
		return this.canceled;
	}
	public void setCanceled(LocalDateTime canceled) {
		this.canceled = canceled;
	}

}
