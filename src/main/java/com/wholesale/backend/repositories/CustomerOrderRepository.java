package com.wholesale.backend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wholesale.backend.models.entities.CustomerOrder;

@Repository
public interface CustomerOrderRepository extends CrudRepository<CustomerOrder, Long> {
    
}
