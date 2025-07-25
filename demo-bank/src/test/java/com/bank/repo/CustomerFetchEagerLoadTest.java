package com.bank.repo;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.bank.entity.AccountEntity;
import com.bank.entity.CustomerEntity;

@SpringBootTest
@ActiveProfiles("test")
class CustomerFetchEagerLoadTest {

    @Autowired
    private ICustomerRepo customerRepo;

    @Test
    void testSaveCustomerWithAccount() {
        CustomerEntity customer = new CustomerEntity();
        customer.setIcNumber("IC123456789");
        customer.setLastname("Tan");
        customer.setSurname("Ahmad");
        customer.setDescription("Test customer with account");
        customer.setCreationDate(LocalDateTime.now());

        AccountEntity account = new AccountEntity();
        account.setAccountNumber("ACC00112233");
        account.setBalance(5000.0);
        account.setCreationDate(LocalDateTime.now());
        account.setCustomerEntity(customer);

        customer.setAccountEntities(List.of(account));

        CustomerEntity savedCustomer = customerRepo.save(customer);
        assertNotNull(savedCustomer);

        CustomerEntity found = customerRepo.findById(savedCustomer.getCustomerID()).get();
        assertNotNull(found);
        assertNotNull(found.getAccountEntities().get(0)); // Will fail if LAZY, pass if EAGER
    }
}
