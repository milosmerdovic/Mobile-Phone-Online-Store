package com.test.demo.service;

import java.util.Collections;
import java.util.Optional;

import com.test.demo.entity.User;
import com.test.demo.repository.RoleRepository;
import com.test.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    private static final String USER_ROLE = "ROLE_USER";

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User saveUser(User user) {
        // Encode plaintext password
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActive(1);
        // Set Role to ROLE_USER
        user.setRoles(Collections.singletonList(roleRepository.findByRole(USER_ROLE)));
        return userRepository.save(user);
    }
    
}