package com.example.telstore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.telstore.exception.ProductNotFoundException;
import com.example.telstore.model.Product;
import com.example.telstore.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(Long id){
        return productRepository.findById(id).orElseThrow( () -> new ProductNotFoundException(id));
    }

    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    public Product updateProduct(Long id,Product updatedProduct){
        Product existingProduct = getProductById(id);
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setBrand(updatedProduct.getBrand());
            existingProduct.setDescription(updatedProduct.getDescription());
            existingProduct.setPrice(updatedProduct.getPrice());
            existingProduct.setCategory(updatedProduct.getCategory());
            existingProduct.setImageUrl(updatedProduct.getImageUrl());
            existingProduct.setStockQuantity(updatedProduct.getStockQuantity());

            return productRepository.save(existingProduct);
    }

    public void deleteProduct(Long id){
         Product existingProduct = getProductById(id);
         productRepository.delete(existingProduct);
    }

}
