package com.example.telstore.service;

import org.springframework.stereotype.Service;

import com.example.telstore.exception.CartItemNotFoundException;
import com.example.telstore.exception.CartNotFoundException;
import com.example.telstore.exception.PlanNotFoundException;
import com.example.telstore.exception.ProductNotFoundException;
import com.example.telstore.model.Cart;
import com.example.telstore.model.CartItem;
import com.example.telstore.model.Plan;
import com.example.telstore.model.Product;
import com.example.telstore.repository.CartItemRepository;
import com.example.telstore.repository.CartRepository;
import com.example.telstore.repository.PlanRepository;
import com.example.telstore.repository.ProductRepository;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final ProductRepository productRepository;
    private final PlanRepository planRepository;

    public CartService(CartRepository cartRepository,
                       CartItemRepository cartItemRepository,
                       ProductRepository productRepository,
                       PlanRepository planRepository) {
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
        this.productRepository = productRepository;
        this.planRepository = planRepository;
    }

    public Cart createCart() {
        Cart cart = new Cart();
        return cartRepository.save(cart);
    }

    public Cart getCartById(Long cartId) {
        return cartRepository.findById(cartId).orElseThrow( () -> new CartNotFoundException(cartId) );
    }

    public Cart addItemToCart(Long cartId, Long productId, Long planId, Integer quantity) {
        Cart cart = getCartById(cartId);

        if (quantity == null || quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }

        if (productId == null && planId == null) {
            throw new IllegalArgumentException("Cart item must contain at least a product or a plan");
        }

        Product product = null;
        if (productId != null) {
            product = productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException(productId));
        }

        Plan plan = null;
        if (planId != null) {
            plan = planRepository.findById(planId).orElseThrow(() -> new PlanNotFoundException(planId));
        }
        
        final Product selectedProduct = product;

        CartItem existingItem = null;
        // It will only merge if it is product only 
        if (product != null && plan == null){
            existingItem = cart.getItems().stream()
            .filter( item -> item.getPlan() == null && isSameProduct(item.getProduct(), selectedProduct))
            .findFirst()
            .orElse(null);
        }

        if (existingItem != null){
            existingItem.setQuantity(existingItem.getQuantity() + quantity );
        }else{
        // Creating new Cart 
        CartItem cartItem = new CartItem();
        cartItem.setCart(cart);
        cartItem.setProduct(product);
        cartItem.setPlan(plan);
        cartItem.setQuantity(quantity);

        cart.getItems().add(cartItem);
        }
        return cartRepository.save(cart);
    }

    public Cart removeItemFromCart(Long cartId, Long cartItemId) {

        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new CartNotFoundException(cartId));

        CartItem itemToRemove = cart.getItems()
                .stream()
                .filter(item -> item.getId().equals(cartItemId))
                .findFirst()
                .orElseThrow(() -> new CartItemNotFoundException(cartItemId));

        cart.getItems().remove(itemToRemove);

        return cartRepository.save(cart);
    }
    // Helper method
    private boolean isSameProduct(Product existingProduct, Product newProduct) {
            if (existingProduct == null && newProduct == null) {
                return true;
            }
            if (existingProduct == null || newProduct == null) {
                return false;
            }
            return existingProduct.getId().equals(newProduct.getId());
        }

}