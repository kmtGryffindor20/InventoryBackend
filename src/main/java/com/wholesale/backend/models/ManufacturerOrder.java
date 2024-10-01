package com.wholesale.backend.models;

import java.sql.Date;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "customer_orders")
public class ManufacturerOrder{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long manufacturerOrderId;

    @ManyToOne
    private Manufacturer orderedFrom;

    private Date dateOfOrder;

    @OneToMany
    private Set<Product> products;
}