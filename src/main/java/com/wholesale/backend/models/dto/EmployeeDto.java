package com.wholesale.backend.models.dto;

import java.sql.Date;
import java.util.Set;

import com.wholesale.backend.models.entities.Employee;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    
    private Long employeeId;

    private String firstName;

    private String lastName;

    private Set<String> emailAddress;
    
    private String phoneNumber;

    private Date hireDate;

    private String designation;

    private Employee manager;

}
