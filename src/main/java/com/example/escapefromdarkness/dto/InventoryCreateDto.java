package com.example.escapefromdarkness.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class InventoryCreateDto {
  private String username;

  private String idItem;

  private int quantity;
}
