package com.example.escapefromdarkness.controllers;

import com.example.escapefromdarkness.dto.AccountCreateDto;
import com.example.escapefromdarkness.dto.AccountLevelUpdateDto;
import com.example.escapefromdarkness.dto.AccountSettingUpdateDto;
import com.example.escapefromdarkness.exception.InvalidRequestException;
import com.example.escapefromdarkness.models.Account;
import com.example.escapefromdarkness.models.Level;
import com.example.escapefromdarkness.models.Setting;
import com.example.escapefromdarkness.models.Skill;
import com.example.escapefromdarkness.services.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {

  private final AccountService accountService;

  @GetMapping()
  public ResponseEntity<List<Account>> findAll() {
    return ResponseEntity.ok(accountService.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Account> find(@PathVariable("id") String id) {
    return ResponseEntity.ok(accountService.findOne(id));
  }

  @GetMapping("/{id}/skills")
  public ResponseEntity<List<Skill>> findSkillsByUsername(@PathVariable("id") String id) {
    return ResponseEntity.ok(accountService.findSkillsByUsername(id));
  }

  @GetMapping("/{id}/level")
  public ResponseEntity<Level> findLevelByUsername(@PathVariable("id") String id) throws InvalidRequestException {
    return ResponseEntity.ok(accountService.findLevelByUsername(id));
  }

  @PutMapping("/{id}/level")
  public ResponseEntity<Level> updateLevelByUsername(@PathVariable("id") String id, @RequestBody AccountLevelUpdateDto accountLevelUpdateDto) throws InvalidRequestException {
    return ResponseEntity.ok(accountService.updateLevelByUsername(id, accountLevelUpdateDto));
  }

  @GetMapping("/{id}/setting")
  public ResponseEntity<Setting> findSettingByUsername(@PathVariable("id") String id) throws InvalidRequestException {
    return ResponseEntity.ok(accountService.findSettingByUsername(id));
  }

  @PutMapping("/{id}/setting")
  public ResponseEntity<Setting> updateSettingByUsername(@PathVariable("id") String id, @RequestBody AccountSettingUpdateDto accountSettingUpdateDto) throws InvalidRequestException {
    return ResponseEntity.ok(accountService.updateSettingByUsername(id, accountSettingUpdateDto));
  }

  @PostMapping("/register")
  public ResponseEntity<Account> create(@RequestBody AccountCreateDto accountCreateDto) throws InvalidRequestException {
    return ResponseEntity.ok(accountService.create(accountCreateDto));
  }

//  @PostMapping("/login")
//  public ResponseEntity<Account> login(@RequestBody AccountLoginDto accountLoginDto) {
//    return ResponseEntity.ok(accountService.login(accountLoginDto));
//  }
}
