package com.test.demo.repository;

import java.util.List;

import com.test.demo.entity.Order;
import com.test.demo.entity.StatusHistory;

import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface StatusHistoryRepository extends JpaRepository <StatusHistory , Integer>{
    List <StatusHistory> findByOrder(Order order);
}
