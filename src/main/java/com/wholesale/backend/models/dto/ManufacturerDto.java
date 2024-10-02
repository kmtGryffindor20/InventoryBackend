package com.wholesale.backend.models.dto;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ManufacturerDto {
    
    private Long manufacturerId;

    private String manufacturerName;

    private String address;

    private Set<String> emailAddress;

    private Set<String> contactNumbers;
}
