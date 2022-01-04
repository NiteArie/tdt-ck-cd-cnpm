package com.example.escapefromdarkness.services;

import com.example.escapefromdarkness.dto.AccountCreateDto;
import com.example.escapefromdarkness.models.Account;
import com.example.escapefromdarkness.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AccountService {
  @Autowired
  AccountRepository accountRepository;

  public List<Account> findAll() {
    return accountRepository.findAll();
  }

  public Account findOne(String id) {
    var account = accountRepository.findById(id);
    if (account.isEmpty()) {
      return null;
    }
    return account.get();
  }

  @Transactional
  public Account create(AccountCreateDto accountCreateDto) {
    Account account = new Account();
    account.setCoin(0);
    account.setCurrentHealth(100);
    account.setCurrentMana(100);
    account.setUsername(accountCreateDto.getUsername());
    account.setPassword(accountCreateDto.getPassword());
    account.setX(0.0);
    account.setY(0.0);

    return accountRepository.save(account);

  }
}
