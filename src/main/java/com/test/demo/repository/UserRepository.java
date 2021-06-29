package com.test.demo.repository;

import java.util.Optional;

import com.test.demo.entity.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository <User, Long>{

    Optional<User> findByName(@Param("name") String name);

    Optional<User> findByEmail(@Param("email") String email);
    
}