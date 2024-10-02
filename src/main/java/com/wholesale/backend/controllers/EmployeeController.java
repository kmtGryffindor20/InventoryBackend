package com.wholesale.backend.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wholesale.backend.mappers.Mapper;
import com.wholesale.backend.models.dto.EmployeeDto;
import com.wholesale.backend.models.entities.Employee;
import com.wholesale.backend.services.EmployeeService;

@RestController
public class EmployeeController {
    
    private EmployeeService employeeService;

    private Mapper<Employee, EmployeeDto> employeeMapper;

    public EmployeeController(EmployeeService employeeService, Mapper<Employee, EmployeeDto> employeeMapper) {
        this.employeeService = employeeService;
        this.employeeMapper = employeeMapper;
    }

    @GetMapping("/employees")
    public Iterable<EmployeeDto> getAllEmployees() {

        Iterable<Employee> employees = employeeService.getAllEmployees();
        return employeeMapper.mapToDto(employees);
    }

    @PostMapping("/employees")
    public EmployeeDto createEmployee(@RequestBody EmployeeDto employee) {

        Employee employeeEntity = employeeMapper.mapToEntity(employee);
        Employee savedEmployee = employeeService.createEmployee(employeeEntity);
        return employeeMapper.mapToDto(savedEmployee);
    }

}
