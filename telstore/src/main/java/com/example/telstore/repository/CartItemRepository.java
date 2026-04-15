package com.example.telstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.telstore.model.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}