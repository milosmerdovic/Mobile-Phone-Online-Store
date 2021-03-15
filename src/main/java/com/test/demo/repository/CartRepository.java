package com.test.demo.repository;

import java.util.List;

import com.test.demo.entity.CartItem;
import com.test.demo.entity.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends CrudRepository <CartItem, Integer> {
    public List <CartItem> findByUser(User user);
}