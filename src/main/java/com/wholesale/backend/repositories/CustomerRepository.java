package com.wholesale.backend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wholesale.backend.models.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, String> {

}
