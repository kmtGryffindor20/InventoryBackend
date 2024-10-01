package com.wholesale.backend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wholesale.backend.models.OrderReturns;

@Repository
public interface OrderReturnsRepository extends CrudRepository<OrderReturns, Long> {
    
}
