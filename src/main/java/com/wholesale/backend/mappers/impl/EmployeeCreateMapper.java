package com.wholesale.backend.mappers.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.wholesale.backend.mappers.Mapper;
import com.wholesale.backend.models.dto.EmployeeCreateDto;
import com.wholesale.backend.models.entities.Employee;
import com.wholesale.backend.repositories.EmployeeRepository;

@Component
public class EmployeeCreateMapper implements Mapper<Employee,EmployeeCreateDto> {

    private ModelMapper modelMapper;

    private EmployeeRepository employeeRepository;

    public EmployeeCreateMapper(ModelMapper modelMapper, EmployeeRepository employeeRepository) {
        this.modelMapper = modelMapper;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeCreateDto mapToDto(Employee entity) {
        return modelMapper.map(entity, EmployeeCreateDto.class);
    }

    @Override
    public Employee mapToEntity(EmployeeCreateDto dto) {
        Employee emp = Employee.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .emailAddress(dto.getEmailAddress())
                .phoneNumber(dto.getPhoneNumber())
                .designation(dto.getDesignation())
                .hireDate(dto.getHireDate())
                .build();

        if (dto.getManagerId() != null) {
            Optional<Employee> managerOptional = employeeRepository.findById(dto.getManagerId());
            if (!managerOptional.isPresent()) {
                throw new RuntimeException("Manager not found");
            }
            Employee manager = managerOptional.get();
            emp.setManager(manager);
        }

        return emp;
    }

    @Override
    public Iterable<EmployeeCreateDto> mapToDto(Iterable<Employee> entities) {
        
        List<EmployeeCreateDto> EmployeeCreateDtos = new ArrayList<>();
        
        for (Employee employee : entities) {
            EmployeeCreateDtos.add(modelMapper.map(employee, EmployeeCreateDto.class));
        }
        return EmployeeCreateDtos;

    }

    @Override
    public Iterable<Employee> mapToEntity(Iterable<EmployeeCreateDto> dtos) {
        
        List<Employee> employees = new ArrayList<>();
        
        for (EmployeeCreateDto EmployeeCreateDto : dtos) {
            employees.add(modelMapper.map(EmployeeCreateDto, Employee.class));
        }
        return employees;

    }

    


    
}
