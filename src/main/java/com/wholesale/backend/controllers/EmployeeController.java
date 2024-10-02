package com.wholesale.backend.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wholesale.backend.mappers.Mapper;
import com.wholesale.backend.models.dto.EmployeeCreateDto;
import com.wholesale.backend.models.dto.EmployeeDto;
import com.wholesale.backend.models.entities.Employee;
import com.wholesale.backend.services.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    
    private EmployeeService employeeService;

    private Mapper<Employee, EmployeeDto> employeeMapper;

    private Mapper<Employee, EmployeeCreateDto> employeeCreateMapper;

    public EmployeeController(EmployeeService employeeService, 
                                    Mapper<Employee,EmployeeDto> employeeMapper,
                                     Mapper<Employee, EmployeeCreateDto> employeeCreateMapper) {
        this.employeeService = employeeService;
        this.employeeMapper = employeeMapper;
        this.employeeCreateMapper = employeeCreateMapper;
    }

    @GetMapping("/employees")
    public Iterable<EmployeeDto> getAllEmployees() {

        Iterable<Employee> employees = employeeService.getAllEmployees();
        return employeeMapper.mapToDto(employees);
    }

    @PostMapping("/employees")
    public EmployeeDto createEmployee(@RequestBody EmployeeCreateDto employee) {
        Employee savedEmployee = employeeService.createEmployee(employee);
        return employeeMapper.mapToDto(savedEmployee);
    }

}
