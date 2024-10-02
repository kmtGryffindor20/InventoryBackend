package com.wholesale.backend.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Table(name = "customers")
public class Customer {
    
    @Id
    private String emailId;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String shippingAddress;

    private String billingAddress;

}
