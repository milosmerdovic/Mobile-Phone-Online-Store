package com.test.demo.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class StatusHistory {
    
    @Id
    @GeneratedValue
    private int id;
    
    @ManyToOne
    private Order order;

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

    public StatusHistory() {
    }

    public StatusHistory(int id, Order order, LocalDateTime sent, LocalDateTime returned, LocalDateTime finished, LocalDateTime canceled) {
        this.id = id;
        this.order = order;
        this.sent = sent;
        this.returned = returned;
        this.finished = finished;
        this.canceled = canceled;
    }

    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
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

    public Order getOrder() {
        return this.order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "{" +
            " sent='" + getSent() + "'" +
            ", returned='" + getReturned() + "'" +
            ", finished='" + getFinished() + "'" +
            ", canceled='" + getCanceled() + "'" +
            ", order='" + getOrder() + "'" +
            "}";
    }
    
}
