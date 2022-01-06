package com.example.escapefromdarkness.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Data
@Entity
@IdClass(InventoryId.class)
@AllArgsConstructor
@RequiredArgsConstructor
public class Inventory {
  @Id
  @Column(name = "id")
  private String username;

  @Id
  private String idItem;

  private int quantity;
}
