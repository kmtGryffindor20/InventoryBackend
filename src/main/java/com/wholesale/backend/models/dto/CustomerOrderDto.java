package com.wholesale.backend.models.dto;

import java.sql.Date;
import java.util.Set;

import com.wholesale.backend.models.entities.Customer;
import com.wholesale.backend.models.entities.Employee;
import com.wholesale.backend.models.entities.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerOrderDto {

    private Long orderId;

    private Customer customer;

    private Date dateOfOrder;

    private String paymentMethod;

    private Employee processedBy;

    private Set<Product> products;
}
