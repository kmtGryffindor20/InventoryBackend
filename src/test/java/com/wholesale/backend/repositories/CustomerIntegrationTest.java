package com.wholesale.backend.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.wholesale.backend.models.Customer;
import com.wholesale.backend.utils.TestDataUtil;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class CustomerIntegrationTest {
    
    private CustomerRepository customerRepositoryTest;

    @Autowired
    public CustomerIntegrationTest(CustomerRepository customerRepositoryTest) {
        this.customerRepositoryTest = customerRepositoryTest;
    }

    @Test
    public void testCreateCustomer() {
        // Create a new customer
        Customer customer = TestDataUtil.createCustomer();

        customerRepositoryTest.save(customer);

        Optional<Customer> result = customerRepositoryTest.findById(customer.getEmailId());

        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(customer);
        
    }
    


}
