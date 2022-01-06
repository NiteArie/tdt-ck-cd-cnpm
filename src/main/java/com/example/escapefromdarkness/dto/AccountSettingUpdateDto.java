package com.example.escapefromdarkness.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AccountSettingUpdateDto {
  private int volume;

  private boolean hasEffect;

  private boolean hasMusic;
}
