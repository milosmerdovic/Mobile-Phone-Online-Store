package com.test.demo.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class StatusHistory {
    
    @Id
    @GeneratedValue
    private int id;
    
    @ManyToOne
    private Order order;
    
    @Column(name="status")
    @Enumerated(EnumType.STRING)
    private Status status;
    
    @Column(name="Date_and_Time")
    private LocalDateTime dateTime;

    public StatusHistory() {
    }

    public StatusHistory(int id, Order order, Status status, LocalDateTime dateTime) {
        this.id = id;
        this.order = order;
        this.status = status;
        this.dateTime = dateTime;
    }

    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Order getOrder() {
        return this.order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }

    public Status getStatus() {
        return this.status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getDateTime() {
        return this.dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
    
}
