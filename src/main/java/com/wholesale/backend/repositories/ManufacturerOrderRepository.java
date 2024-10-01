package com.wholesale.backend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wholesale.backend.models.ManufacturerOrder;

@Repository
public interface ManufacturerOrderRepository extends CrudRepository<ManufacturerOrder, Long> {
    
}
