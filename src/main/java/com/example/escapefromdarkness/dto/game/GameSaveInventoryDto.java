package com.example.escapefromdarkness.dto.game;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class GameSaveInventoryDto {
  private String username;

  private String idItem;

  private int quantity;
}
