package com.example.escapefromdarkness.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Enemy {
  @Id
  @Column(name = "id")
  private String id;

  private int health;

  @Column(length = 2000)
  private String description;

  private int dameAttack;

  private int maxHealth;
}
