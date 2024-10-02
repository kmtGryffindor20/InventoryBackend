package com.wholesale.backend.models.dto;

import java.sql.Date;
import java.util.Set;

import com.wholesale.backend.models.entities.Category;
import com.wholesale.backend.models.entities.Manufacturer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    
    private Long productId;

    private String productName;

    private Date expiryDate;

    private Long stockQuantity;

    private Double costPrice;

    private Double maximumRetailPrice;

    private Category category;

    private Set<Manufacturer> manufacturers;
}
