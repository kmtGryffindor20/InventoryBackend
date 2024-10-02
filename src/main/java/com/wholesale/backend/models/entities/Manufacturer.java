package com.wholesale.backend.models.entities;

import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@Table(name = "manufacturers")
public class Manufacturer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long manufacturerId;

    private String manufacturerName;

    private String address;

    @ElementCollection
    @CollectionTable(name = "manufacturer_email_addresses")
    private Set<String> emailAddress;

    @ElementCollection
    @CollectionTable(name = "manufacturer_contact_numbers")
    private Set<String> contactNumbers;

}
