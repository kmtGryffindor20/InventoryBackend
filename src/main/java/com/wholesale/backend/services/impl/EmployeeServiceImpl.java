package com.wholesale.backend.services.impl;


import org.springframework.stereotype.Service;

import com.wholesale.backend.mappers.Mapper;
import com.wholesale.backend.models.dto.EmployeeCreateDto;
import com.wholesale.backend.models.entities.Employee;
import com.wholesale.backend.repositories.EmployeeRepository;
import com.wholesale.backend.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    
    private EmployeeRepository employeeRepository;

    private Mapper<Employee, EmployeeCreateDto> employeeCreateMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, Mapper<Employee, EmployeeCreateDto> employeeCreateMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeCreateMapper = employeeCreateMapper;
    }

    @Override
    public Iterable<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee createEmployee(EmployeeCreateDto employee) {
        Employee newEmployee = employeeCreateMapper.mapToEntity(employee);
        if (employee.getManagerId() != null) {
            Employee manager = employeeRepository.findById(employee.getManagerId()).get();
            System.out.println(manager.getFirstName());
            newEmployee.setManager(manager);
        }
        return employeeRepository.save(newEmployee);
    }

    

}
