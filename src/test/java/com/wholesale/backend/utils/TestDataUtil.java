package com.wholesale.backend.utils;

import com.wholesale.backend.models.Category;
import com.wholesale.backend.models.Customer;
import com.wholesale.backend.models.Product;

public final class TestDataUtil {
    
    private TestDataUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static Product createProduct(final Category category) {
        return Product.builder()
                .productName("Product 1")
                .expiryDate(java.sql.Date.valueOf("2022-12-31"))
                .stockQuantity(100L)
                .costPrice(100.0)
                .maximumRetailPrice(150.0)
                .category(category)
                .build();
    }

    public static Category createCategory() {
        return Category.builder()
                .categoryName("Category 1")
                .build();
    }

    public static Customer createCustomer() {
        return Customer.builder()
                .emailId("johndoe@gmail.com")
                .firstName("John")
                .lastName("Doe")
                .phoneNumber("1234567890")
                .shippingAddress("123, Main Street, New York, USA")
                .billingAddress("123, Main Street, New York, USA")
                .build();

    }


}
