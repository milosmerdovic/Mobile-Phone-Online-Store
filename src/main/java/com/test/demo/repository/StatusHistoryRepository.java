package com.test.demo.repository;

import com.test.demo.entity.StatusHistory;

import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface StatusHistoryRepository extends JpaRepository <StatusHistory , Integer>{
}
