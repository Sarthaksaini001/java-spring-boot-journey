package com.example.telstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.telstore.model.Product;

// Revision Note :- 
// JpaRepository<Product, Long> :- In this Product - which entity this repository manages | Long - Type of Primary Key which is ID here 
public interface ProductRepository extends JpaRepository<Product, Long> {
}
