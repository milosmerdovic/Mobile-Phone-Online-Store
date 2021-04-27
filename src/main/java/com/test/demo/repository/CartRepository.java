package com.test.demo.repository;


import com.test.demo.entity.CartItem;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends CrudRepository <CartItem, Long> {

    
}