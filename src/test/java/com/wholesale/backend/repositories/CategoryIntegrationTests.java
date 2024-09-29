package com.wholesale.backend.repositories;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.wholesale.backend.models.Category;
import com.wholesale.backend.utils.TestDataUtil;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class CategoryIntegrationTests {
    
    private CategoryRepository categoryRepositoryTest;

    @Autowired
    public CategoryIntegrationTests(CategoryRepository categoryRepositoryTest) {
        this.categoryRepositoryTest = categoryRepositoryTest;
    }

    @Test
    public void testCreateCategory() {
        // Create a new category
        Category category = TestDataUtil.createCategory();

        categoryRepositoryTest.save(category);

        Optional<Category> result = categoryRepositoryTest.findById(category.getCategoryId());

        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(category);
        
    }
}
