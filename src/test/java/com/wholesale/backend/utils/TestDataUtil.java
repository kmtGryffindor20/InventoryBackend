package com.wholesale.backend.utils;

import com.wholesale.backend.models.entities.Category;
import com.wholesale.backend.models.entities.Customer;
import com.wholesale.backend.models.entities.Product;

public final class TestDataUtil {
    
    private TestDataUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static Product createProductA(final Category category) {
        return Product.builder()
                .productName("Product A")
                .expiryDate(java.sql.Date.valueOf("2022-12-31"))
                .stockQuantity(100L)
                .costPrice(100.0)
                .maximumRetailPrice(150.0)
                .category(category)
                .build();
    }

    public static Product createProductB(final Category category) {
        return Product.builder()
                .productName("Product B")
                .expiryDate(java.sql.Date.valueOf("2022-12-31"))
                .stockQuantity(100L)
                .costPrice(100.0)
                .maximumRetailPrice(150.0)
                .category(category)
                .build();
    }

    public static Product createProductC(final Category category) {
        return Product.builder()
                .productName("Product C")
                .expiryDate(java.sql.Date.valueOf("2022-12-31"))
                .stockQuantity(100L)
                .costPrice(100.0)
                .maximumRetailPrice(150.0)
                .category(category)
                .build();
    }

    public static Category createCategoryA() {
        return Category.builder()
                .categoryName("Category A")
                .build();
    }
    public static Category createCategoryB() {
        return Category.builder()
                .categoryName("Category B")
                .build();
    }

    public static Customer createCustomer(String email) {
        return Customer.builder()
                .emailId(email)
                .firstName("John")
                .lastName("Doe")
                .phoneNumber("1234567890")
                .shippingAddress("123, Main Street, New York, USA")
                .billingAddress("123, Main Street, New York, USA")
                .build();

    }


}
