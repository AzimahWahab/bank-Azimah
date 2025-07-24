package com.bank.mapper;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bank.entity.AccountEntity;
import com.bank.model.AccountDTO;

@SpringBootTest
public class AccountMapperTest {

    @Autowired
    private AccountMapper accountMapper;
    
	@Test
    void testEntityToDtoAndBack() {
        // Create sample AccountEntity
        AccountEntity account = new AccountEntity();
        account.setAccountID(1L);
        account.setAccountNumber("ACC123");
        account.setBalance(1000.0);

        // Convert to DTO
        AccountDTO dto = accountMapper.toDto(account);

    	assertNotNull(dto);
    	assertNotNull(dto.getAccountID());
    }
}
