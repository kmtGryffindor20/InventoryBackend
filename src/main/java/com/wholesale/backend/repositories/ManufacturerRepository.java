package com.wholesale.backend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wholesale.backend.models.Manufacturer;

@Repository
public interface ManufacturerRepository extends CrudRepository<Manufacturer, Long> {
    
}
