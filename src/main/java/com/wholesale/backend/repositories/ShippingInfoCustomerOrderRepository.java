package com.wholesale.backend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wholesale.backend.models.ShippingInfoCustomerOrder;

@Repository
public interface ShippingInfoCustomerOrderRepository extends CrudRepository<ShippingInfoCustomerOrder, Long> {
    
}
