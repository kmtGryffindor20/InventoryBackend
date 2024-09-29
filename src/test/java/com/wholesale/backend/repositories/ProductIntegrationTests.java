package com.wholesale.backend.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.wholesale.backend.models.Category;
import com.wholesale.backend.models.Product;
import com.wholesale.backend.utils.TestDataUtil;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ProductIntegrationTests {
    
    private ProductRepository productRepositoryTest;

    @Autowired
    public ProductIntegrationTests(ProductRepository productRepositoryTest) {
        this.productRepositoryTest = productRepositoryTest;
    }

    @Test
    public void testCreateProduct() {
        // Create a new product
        Category category = TestDataUtil.createCategory();
        Product product = TestDataUtil.createProduct(category);

        productRepositoryTest.save(product);

        Optional<Product> result = productRepositoryTest.findById(product.getProductId());

        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(product);
    }

}
