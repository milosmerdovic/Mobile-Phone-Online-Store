package com.test.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.demo.entity.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer>{

}
