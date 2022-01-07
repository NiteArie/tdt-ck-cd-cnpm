package com.example.escapefromdarkness.services;

import com.example.escapefromdarkness.dto.AccountCreateDto;
import com.example.escapefromdarkness.dto.AccountLevelUpdateDto;
import com.example.escapefromdarkness.dto.AccountSettingUpdateDto;
import com.example.escapefromdarkness.exception.InvalidRequestException;
import com.example.escapefromdarkness.models.Account;
import com.example.escapefromdarkness.models.Level;
import com.example.escapefromdarkness.models.Setting;
import com.example.escapefromdarkness.models.Skill;
import com.example.escapefromdarkness.repositories.AccountRepository;
import com.example.escapefromdarkness.repositories.LevelRepository;
import com.example.escapefromdarkness.repositories.SettingRepository;
import com.example.escapefromdarkness.repositories.SkillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

  private final AccountRepository accountRepository;
  private final SettingRepository settingRepository;
  private final LevelRepository levelRepository;
  private final SkillRepository skillRepository;
  private final BCryptPasswordEncoder bCryptPasswordEncoder;

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

  public List<Skill> findSkillsByUsername(String id) {
    var skills = skillRepository.findByUsername(id);
    return skills;
  }

  public Level findLevelByUsername(String id) throws InvalidRequestException {
    var account = accountRepository.findById(id);
    if (account.isEmpty()) {
      throw new InvalidRequestException("Account with username doesn't exist");
    }
    var level = levelRepository.findById(account.get().getIdLevel());
    return level.get();
  }

  public Level updateLevelByUsername(String id, AccountLevelUpdateDto accountLevelUpdateDto) throws InvalidRequestException {
    var account = accountRepository.findById(id);
    if (account.isEmpty()) {
      throw new InvalidRequestException("Account with username doesn't exist");
    }
    var level = levelRepository.findById(accountLevelUpdateDto.getLevel());
    if (level.isEmpty()) {
      throw new InvalidRequestException(String.format("This level (%s) doesn't exist", accountLevelUpdateDto.getLevel()));
    }
    account.get().setIdLevel(accountLevelUpdateDto.getLevel());
    accountRepository.save(account.get());
    return level.get();
  }

  public Setting findSettingByUsername(String id) throws InvalidRequestException {
    var account = accountRepository.findById(id);
    if (account.isEmpty()) {
      throw new InvalidRequestException("Account with username doesn't exist");
    }
    var setting = settingRepository.findById(account.get().getIdSetting());
    return setting.get();
  }

  public Setting updateSettingByUsername(String id, AccountSettingUpdateDto accountSettingUpdateDto) throws InvalidRequestException {
    System.out.println(id);
    var account = accountRepository.findById(id);

    if (account.isEmpty()) {
      throw new InvalidRequestException("Account with username doesn't exist");
    }

    var setting = settingRepository.findById(id);
    setting.get().setVolume(accountSettingUpdateDto.getVolume());
    setting.get().setHasEffect(accountSettingUpdateDto.isHasEffect());
    setting.get().setHasMusic(accountSettingUpdateDto.isHasMusic());
    return settingRepository.save(setting.get());
  }

  @Transactional
  public Account create(AccountCreateDto accountCreateDto) throws InvalidRequestException {

    if (accountRepository.existsById(accountCreateDto.getUsername())) {
      throw new InvalidRequestException("Username already exist!");
    }

    Account account = new Account();
    account.setCoin(200);
    account.setCurrentHealth(1000);
    account.setCurrentMana(1000);
    account.setUsername(accountCreateDto.getUsername());
    account.setPassword(bCryptPasswordEncoder.encode(accountCreateDto.getPassword()));
    account.setX(10.0);
    account.setY(-6.0);

    var level = levelRepository.findById(1);
    if (level.isPresent()) {
      account.setIdLevel(1);
    }

    Setting setting = new Setting();
    setting.setUsername(account.getUsername());
    setting.setHasEffect(true);
    setting.setHasMusic(true);
    setting.setVolume(50);
    settingRepository.save(setting);

    account.setIdSetting(setting.getUsername());

    return accountRepository.save(account);

  }
}
