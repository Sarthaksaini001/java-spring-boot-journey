package com.example.telstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.telstore.model.Plan;

public interface PlanRepository extends JpaRepository<Plan, Long> {
}