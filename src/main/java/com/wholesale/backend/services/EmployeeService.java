package com.wholesale.backend.services;


import com.wholesale.backend.models.dto.EmployeeCreateDto;
import com.wholesale.backend.models.entities.Employee;

public interface EmployeeService {
        
        public Iterable<Employee> getAllEmployees();
        
        // public Employee getEmployeeById(Long id);
        
        public Employee createEmployee(EmployeeCreateDto employee);
        
        // public Employee updateEmployee(Long id, Employee employee);
        
        // public void deleteEmployee(Long id);
}
