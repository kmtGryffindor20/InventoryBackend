package com.wholesale.backend.models;



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
@Table(name = "customer_order_shipping_info")
public class ShippingInfoCustomerOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long shippingInfoId;

    private Date dateOfShipping;

    private Date expectedDateOfDelivery;

    private String status;

    @ManyToOne
    private CustomerOrder order;
}
