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
        Customer customer = TestDataUtil.createCustomer("x@x.c");

        customerRepositoryTest.save(customer);

        Optional<Customer> result = customerRepositoryTest.findById(customer.getEmailId());

        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(customer);
        
    }

    @Test
    public void findAllCustomers() {

        Customer customerA = TestDataUtil.createCustomer("x@x.c");
        customerRepositoryTest.save(customerA);

        Customer customerB = TestDataUtil.createCustomer("a@b.c");
        customerRepositoryTest.save(customerB);

        assertThat(customerRepositoryTest.findAll())
        .hasSize(2)
        .contains(customerA, customerB);
    }

    @Test
    public void testUpdateCustomer() {
        Customer customer = TestDataUtil.createCustomer("x@x.c");

        customerRepositoryTest.save(customer);

        customer.setFirstName("Mary");
        customer.setLastName("Jane");

        customerRepositoryTest.save(customer);

        Optional<Customer> result = customerRepositoryTest.findById(customer.getEmailId());

        assertThat(result).isPresent();
        assertThat(result.get().getFirstName()).isEqualTo("Mary");
        assertThat(result.get().getLastName()).isEqualTo("Jane");
    }

    @Test
    public void testDeleteCustomer() {
        Customer customer = TestDataUtil.createCustomer("x@x.c");

        customerRepositoryTest.save(customer);

        customerRepositoryTest.deleteById(customer.getEmailId());

        Optional<Customer> result = customerRepositoryTest.findById(customer.getEmailId());

        assertThat(result).isEmpty();
    }
    


}
