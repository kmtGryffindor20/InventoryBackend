package com.wholesale.backend.services.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.wholesale.backend.models.entities.Product;
import com.wholesale.backend.repositories.ProductRepository;
import com.wholesale.backend.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            Product productToUpdate = productOptional.get();
            productToUpdate.setProductName(product.getProductName());
            productToUpdate.setCategory(product.getCategory());
            productToUpdate.setCostPrice(product.getCostPrice());
            productToUpdate.setExpiryDate(product.getExpiryDate());
            productToUpdate.setManufacturers(product.getManufacturers());
            productToUpdate.setMaximumRetailPrice(product.getMaximumRetailPrice());
            productToUpdate.setStockQuantity(product.getStockQuantity());
        }
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
    
}
