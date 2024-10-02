package com.wholesale.backend.models.entities;


import java.sql.Date;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long employeeId;

    private String firstName;

    private String lastName;

    @ElementCollection
    @CollectionTable(name = "employee_email_addresses")
    private Set<String> emailAddress;
    
    private String phoneNumber;

    private Date hireDate;

    private String designation;

    @ManyToOne
    private Employee manager;

}
