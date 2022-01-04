package com.example.escapefromdarkness.services;

import com.example.escapefromdarkness.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountService {
  @Autowired
  AccountRepository accountRepository;

  public void register() {
  }
}
