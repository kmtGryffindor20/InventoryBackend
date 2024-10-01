package com.wholesale.backend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wholesale.backend.models.ShippingInfoManufacturerOrder;

@Repository
public interface ShippingInfoManufacturerOrderRepository extends CrudRepository<ShippingInfoManufacturerOrder, Long> {
    
}
