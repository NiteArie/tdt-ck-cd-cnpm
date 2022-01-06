package com.example.escapefromdarkness.services;

import com.example.escapefromdarkness.dto.AccountCreateDto;
import com.example.escapefromdarkness.exception.InvalidRequestException;
import com.example.escapefromdarkness.models.Account;
import com.example.escapefromdarkness.models.Setting;
import com.example.escapefromdarkness.repositories.AccountRepository;
import com.example.escapefromdarkness.repositories.SettingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

  private final AccountRepository accountRepository;
  private final SettingRepository settingRepository;
  private final BCryptPasswordEncoder bCryptPasswordEncoder;
  private final AuthenticationManager authenticationManager;

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
  public Account create(AccountCreateDto accountCreateDto) throws InvalidRequestException {

    if (accountRepository.existsById(accountCreateDto.getUsername())) {
      throw new InvalidRequestException("Username already exist!");
    }

    Account account = new Account();
    account.setCoin(0);
    account.setCurrentHealth(100);
    account.setCurrentMana(100);
    account.setUsername(accountCreateDto.getUsername());
    account.setPassword(bCryptPasswordEncoder.encode(accountCreateDto.getPassword()));
    account.setX(0.0);
    account.setY(0.0);

    Setting setting = new Setting();
    setting.setUsername(account.getUsername());
    setting.setHasEffect(true);
    setting.setHasMusic(true);
    setting.setVolume(50);
    settingRepository.save(setting);

    account.setSetting(setting);

    return accountRepository.save(account);

  }
}
