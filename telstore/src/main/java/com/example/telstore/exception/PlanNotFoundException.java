package com.example.telstore.exception;

public class PlanNotFoundException extends RuntimeException{
     public PlanNotFoundException(Long id) {
        super("Product not found with id: " + id);
    }

}
