package com.bank.service;

import com.bank.entity.AccountEntity;

import java.util.List;

public interface IAccountService {
    AccountEntity createAccount(AccountEntity account);
    AccountEntity getAccountById(Long id);
    List<AccountEntity> getAllAccounts();
    AccountEntity updateAccount(Long id, AccountEntity updated);
    void deleteAccount(Long id);
}
