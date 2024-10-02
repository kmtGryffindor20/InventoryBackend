package com.wholesale.backend.mappers.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.wholesale.backend.mappers.Mapper;
import com.wholesale.backend.models.dto.EmployeeDto;
import com.wholesale.backend.models.entities.Employee;

@Component
public class EmployeeMapperImpl implements Mapper<Employee, EmployeeDto> {

    private ModelMapper modelMapper;

    public EmployeeMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public EmployeeDto mapToDto(Employee entity) {
        return modelMapper.map(entity, EmployeeDto.class);
    }

    @Override
    public Employee mapToEntity(EmployeeDto dto) {
        return modelMapper.map(dto, Employee.class);
    }

    @Override
    public Iterable<EmployeeDto> mapToDto(Iterable<Employee> entities) {
        
        List<EmployeeDto> employeeDtos = new ArrayList<>();
        
        for (Employee employee : entities) {
            employeeDtos.add(modelMapper.map(employee, EmployeeDto.class));
        }
        return employeeDtos;

    }

    @Override
    public Iterable<Employee> mapToEntity(Iterable<EmployeeDto> dtos) {
        
        List<Employee> employees = new ArrayList<>();
        
        for (EmployeeDto employeeDto : dtos) {
            employees.add(modelMapper.map(employeeDto, Employee.class));
        }
        return employees;

    }

}
