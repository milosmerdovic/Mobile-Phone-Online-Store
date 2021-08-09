package com.test.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.test.demo.entity.OrderItem;
import com.test.demo.entity.Product;

@Repository
public interface OrderItemsRepository extends JpaRepository<OrderItem, Integer>{
    List <OrderItem> findByProduct(Product product);

}
