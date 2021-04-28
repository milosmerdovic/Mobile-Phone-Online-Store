package com.test.demo.repository;

import com.test.demo.entity.Role;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RoleRepository extends CrudRepository <Role, Long> {

    Role findByRole(@Param("role") String role);
    
}