package com.example.escapefromdarkness.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AccountCreateDto {
  private String username;

  private String password;
}
