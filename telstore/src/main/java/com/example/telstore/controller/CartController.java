package com.example.telstore.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.telstore.dto.AddCartItemRequest;
import com.example.telstore.model.Cart;
import com.example.telstore.service.CartService;

@RestController
@RequestMapping("/carts")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping
    public Cart createCart() {
        return cartService.createCart();
    }

    @GetMapping("/{cartId}")
    public Cart getCartById(@PathVariable Long cartId) {
        return cartService.getCartById(cartId);
    }

    @PostMapping("/{cartId}/items")
    public Cart addItemToCart(@PathVariable Long cartId, @RequestBody AddCartItemRequest request) {
        return cartService.addItemToCart(
                cartId,
                request.getProductId(),
                request.getPlanId(),
                request.getQuantity()
        );
    }

    @DeleteMapping("/{cartId}/items/{cartItemId}")
    public Cart removeItemFromCart(@PathVariable Long cartId, @PathVariable Long cartItemId) {
        return cartService.removeItemFromCart(cartId, cartItemId);
    }
}