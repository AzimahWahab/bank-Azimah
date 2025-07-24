package com.bank.controller;

import com.bank.entity.AccountEntity;
import com.bank.entity.CustomerEntity;
import com.bank.mapper.AccountMapper;
import com.bank.mapper.CustomerMapper;
import com.bank.model.AccountDTO;
import com.bank.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/accounts/v1")
public class AccountController {

    @Autowired
    private IAccountService accountService;
    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private AccountMapper accountMapper;

 // CREATE
    @PostMapping
    public ResponseEntity<AccountDTO> create(@RequestBody AccountDTO accountDTO) {
        AccountEntity entity = accountMapper.toEntity(accountDTO);
        CustomerEntity customerEntity = customerMapper.toEntity(accountDTO.getCustomerDTO());
        entity.setCustomerEntity(customerEntity);
        AccountEntity created = accountService.createAccount(entity);
        return ResponseEntity.ok(accountMapper.toDto(created));
    }
    
    // READ by ID
    @GetMapping("/{id}")
    public ResponseEntity<AccountDTO> getById(@PathVariable Long id) {
        AccountEntity entity = accountService.getAccountById(id);
        return ResponseEntity.ok(accountMapper.toDto(entity));
    }

    // READ All
    @GetMapping
    public ResponseEntity<List<AccountDTO>> getAll() {
        List<AccountEntity> accounts = accountService.getAllAccounts();
        List<AccountDTO> dtoList = accounts.stream()
                .map(accountMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtoList);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<AccountDTO> update(@PathVariable Long id, @RequestBody AccountDTO accountDTO) {
        AccountEntity updatedEntity = accountService.updateAccount(id, accountMapper.toEntity(accountDTO));
        return ResponseEntity.ok(accountMapper.toDto(updatedEntity));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        accountService.deleteAccount(id);
        return ResponseEntity.noContent().build();
    }
}
