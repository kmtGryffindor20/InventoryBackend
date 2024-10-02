package com.wholesale.backend.mappers.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.wholesale.backend.mappers.Mapper;
import com.wholesale.backend.models.dto.ProductDto;
import com.wholesale.backend.models.entities.Product;

@Component
public class ProductMapperImpl implements Mapper<Product, ProductDto> {

    private ModelMapper modelMapper;

    public ProductMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public ProductDto mapToDto(Product entity) {
        return modelMapper.map(entity, ProductDto.class);
    }

    @Override
    public Product mapToEntity(ProductDto dto) {
        return modelMapper.map(dto, Product.class);
    }

    @Override
    public Iterable<ProductDto> mapToDto(Iterable<Product> entities) {
        List<ProductDto> productDtos = new ArrayList<>();
        
        for (Product product : entities) {
            productDtos.add(modelMapper.map(product, ProductDto.class));
        }

        return productDtos;
    }

    @Override
    public Iterable<Product> mapToEntity(Iterable<ProductDto> dtos) {
        List<Product> products = new ArrayList<>();
        
        for (ProductDto productDto : dtos) {
            products.add(modelMapper.map(productDto, Product.class));
        }

        return products;
    }
    
}
