package com.example.telstore.dto;
// DTO - Data Transfer Object ( A class used to tranfer data between client and server), 
// It act as a middle man we decided what data user is allowed to send instead of exposing the whole thing 
public class AddCartItemRequest {

    private Long productId;
    private Long planId;
    private Integer quantity;

    public AddCartItemRequest() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}