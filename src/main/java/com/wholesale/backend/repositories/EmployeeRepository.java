package com.wholesale.backend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wholesale.backend.models.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    
}
