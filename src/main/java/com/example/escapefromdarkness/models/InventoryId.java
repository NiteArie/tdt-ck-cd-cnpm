package com.example.escapefromdarkness.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
public class InventoryId implements Serializable {
  private String username;
  private String idItem;
}
