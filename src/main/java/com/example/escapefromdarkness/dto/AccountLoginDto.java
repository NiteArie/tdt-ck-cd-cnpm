package com.example.escapefromdarkness.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AccountLoginDto {
  private String username;

  private String password;
}
