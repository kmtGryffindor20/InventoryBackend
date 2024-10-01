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

import jakarta.transaction.Transactional;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ProductIntegrationTests {
    
    private ProductRepository productRepositoryTest;
    private CategoryRepository categoryRepositoryTest;

    @Autowired
    public ProductIntegrationTests(ProductRepository productRepositoryTest, CategoryRepository categoryRepositoryTest) {
        this.productRepositoryTest = productRepositoryTest;
        this.categoryRepositoryTest = categoryRepositoryTest;
    }

    @Transactional
    @Test
    public void testCreateAndFindProduct() {
        // Create a new product
        Category category = TestDataUtil.createCategoryA();

        categoryRepositoryTest.save(category);
        
        Product product = TestDataUtil.createProductA(category);

        productRepositoryTest.save(product);

        Optional<Product> result = productRepositoryTest.findById(product.getProductId());

        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(product);
    }

    @Transactional
    @Test
    public void findAllProducts() {

        Category category = TestDataUtil.createCategoryA();

        categoryRepositoryTest.save(category);

        Product productA = TestDataUtil.createProductA(category);
        productRepositoryTest.save(productA);

        Product productB = TestDataUtil.createProductB(category);
        productRepositoryTest.save(productB);

        Product productC = TestDataUtil.createProductC(category);
        productRepositoryTest.save(productC);


        Iterable<Product> result = productRepositoryTest.findAll();

        assertThat(result)
            .hasSize(3)
            .contains(productA, productB, productC);


    }

    @Transactional
    @Test
    public void testUpdateProduct() {
        // Create a new product
        Category category = TestDataUtil.createCategoryA();

        categoryRepositoryTest.save(category);
        
        Product product = TestDataUtil.createProductA(category);

        productRepositoryTest.save(product);

        Optional<Product> result = productRepositoryTest.findById(product.getProductId());

        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(product);

        // Update the product
        Product updatedProduct = result.get();
        updatedProduct.setStockQuantity(200L);

        productRepositoryTest.save(updatedProduct);

        Optional<Product> updatedResult = productRepositoryTest.findById(product.getProductId());

        assertThat(updatedResult).isPresent();
        assertThat(updatedResult.get()).isEqualTo(updatedProduct);
    }

    @Transactional
    @Test
    public void testDeleteProduct() {
        // Create a new product
        Category category = TestDataUtil.createCategoryA();

        categoryRepositoryTest.save(category);
        
        Product product = TestDataUtil.createProductA(category);

        productRepositoryTest.save(product);

        Optional<Product> result = productRepositoryTest.findById(product.getProductId());

        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(product);

        // Delete the product
        productRepositoryTest.delete(product);

        Optional<Product> deletedResult = productRepositoryTest.findById(product.getProductId());

        assertThat(deletedResult).isEmpty();
    }

}
