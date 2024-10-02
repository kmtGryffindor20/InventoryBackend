package com.wholesale.backend.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wholesale.backend.mappers.Mapper;
import com.wholesale.backend.models.dto.ProductDto;
import com.wholesale.backend.models.entities.Product;
import com.wholesale.backend.services.ProductService;

import io.swagger.v3.oas.annotations.Operation;


@RestController
@RequestMapping("/api")
public class ProductController {
    
    private ProductService productService;
    
    private Mapper<Product, ProductDto> productMapper;

    public ProductController(ProductService productService, Mapper<Product, ProductDto> productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @Operation(summary = "Get all products")
    @GetMapping("/products")
    public Iterable<ProductDto> getAllProducts() {

        Iterable<Product> products = productService.getAllProducts();
        return productMapper.mapToDto(products);
    }

    @Operation(summary = "Create a product")
    @PostMapping("/products")
    public ProductDto createProduct(@RequestBody ProductDto product) {

        Product productEntity = productMapper.mapToEntity(product);
        Product savedProduct = productService.createProduct(productEntity);
        return productMapper.mapToDto(savedProduct);
    }
    
    @Operation(summary = "Get a product by ID")
    @GetMapping("/products/{id}")
    public ProductDto getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        return productMapper.mapToDto(product);
    }

    @Operation(summary = "Delete a product by ID")
    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }


    @Operation(summary = "Update a product")
    @PatchMapping("/products/{id}")
    public ProductDto updateProductPartially(@RequestBody ProductDto product, @PathVariable Long id) {

        Product productEntity = productMapper.mapToEntity(product);
        Product updatedProduct = productService.updateProduct(id, productEntity);
        return productMapper.mapToDto(updatedProduct);
    }
}
