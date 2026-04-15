package com.example.telstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.telstore.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
