package com.wholesale.backend.services.impl;


import org.springframework.stereotype.Service;

import com.wholesale.backend.models.entities.Employee;
import com.wholesale.backend.repositories.EmployeeRepository;
import com.wholesale.backend.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Iterable<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    

}
