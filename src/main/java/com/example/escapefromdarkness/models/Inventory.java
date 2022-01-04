package com.example.escapefromdarkness.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Inventory {
  @Id
  @Column(name = "id")
  private String username;

  private String idItem;

  private int quantity;
}
