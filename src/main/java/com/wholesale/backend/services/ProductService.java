package com.wholesale.backend.services;

import com.wholesale.backend.models.entities.Product;

public interface ProductService {
    
    public Iterable<Product> getAllProducts();
    
    public Product getProductById(Long id);
    
    public Product createProduct(Product product);
    
    public Product updateProduct(Long id, Product product);
    
    public void deleteProduct(Long id);

}

