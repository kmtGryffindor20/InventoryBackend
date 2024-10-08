package com.wholesale.backend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wholesale.backend.models.entities.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
    
}
