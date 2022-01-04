package com.example.escapefromdarkness.controllers;

import com.example.escapefromdarkness.dto.AccountCreateDto;
import com.example.escapefromdarkness.models.Account;
import com.example.escapefromdarkness.services.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@AllArgsConstructor
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

  @PostMapping()
  public ResponseEntity<Account> create(@RequestBody AccountCreateDto accountCreateDto) {
    return ResponseEntity.ok(accountService.create(accountCreateDto));
  }
}
