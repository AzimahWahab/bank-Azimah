package com.bank.repo;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.bank.entity.AccountEntity;
import com.bank.entity.CustomerEntity;

@SpringBootTest
@ActiveProfiles("test")
class AccountRepoTest {

    @Autowired
    private IAccountRepo accountRepo;

    @Autowired
    private ICustomerRepo customerRepo;

    private CustomerEntity createTestCustomer() {
        CustomerEntity customer = new CustomerEntity();
        customer.setIcNumber("IC112233");
        customer.setLastname("Lim");
        customer.setSurname("Wei");
        customer.setDescription("Account owner");
        customer.setCreationDate(LocalDateTime.now());
        return customerRepo.save(customer);
    }

    @Test
    void testCreateAccount() {
        CustomerEntity customer = createTestCustomer();

        AccountEntity account = new AccountEntity();
        account.setAccountNumber("ACC99887766");
        account.setBalance(10000.0);
        account.setCreationDate(LocalDateTime.now());
        account.setCustomerEntity(customer);

        AccountEntity saved = accountRepo.save(account);

        assertNotNull(saved.getAccountID());
        assertEquals("ACC99887766", saved.getAccountNumber());
    }

    @Test
    void testFindAccountById() {
        CustomerEntity customer = createTestCustomer();

        AccountEntity account = new AccountEntity();
        account.setAccountNumber("ACC55667788");
        account.setBalance(5000.0);
        account.setCreationDate(LocalDateTime.now());
        account.setCustomerEntity(customer);

        AccountEntity saved = accountRepo.save(account);
        Optional<AccountEntity> found = accountRepo.findById(saved.getAccountID());

        assertTrue(found.isPresent());
        assertEquals("ACC55667788", found.get().getAccountNumber());
    }

    @Test
    void testDeleteAccount() {
        CustomerEntity customer = createTestCustomer();

        AccountEntity account = new AccountEntity();
        account.setAccountNumber("ACC33445566");
        account.setBalance(2000.0);
        account.setCreationDate(LocalDateTime.now());
        account.setCustomerEntity(customer);

        AccountEntity saved = accountRepo.save(account);
        Long id = saved.getAccountID();

        accountRepo.deleteById(id);

        Optional<AccountEntity> deleted = accountRepo.findById(id);
        assertFalse(deleted.isPresent());
    }
}
