package com.wholesale.backend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wholesale.backend.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    
}