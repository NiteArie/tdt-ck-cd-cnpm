package com.example.escapefromdarkness.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Level {
  @Id
  @Column(name = "idLevel")
  private String idLevel;

  private int dameAttack;

  private int defense;

  private int maxMana;

  private int maxHealth;

  private int fee;
}
