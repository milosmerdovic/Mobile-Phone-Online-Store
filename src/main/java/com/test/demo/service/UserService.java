package com.test.demo.service;

import java.util.Optional;

import com.test.demo.entity.User;

public interface UserService {
    
    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    User saveUser(User user);
    
}