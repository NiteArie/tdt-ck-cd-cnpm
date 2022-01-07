package com.example.escapefromdarkness.dto.game;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class GameSaveSettingDto {
  private String username;

  private int volume;

  private boolean hasEffect;

  private boolean hasMusic;
}
