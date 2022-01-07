package com.example.escapefromdarkness.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Account {
  @Id
  @Column(name = "username", nullable = false)
  private String username;

  private String password;

  private int coin;

  private int currentHealth;

  private int currentMana;

  private double x;

  private double y;

  @JsonIgnore
  private Integer idLevel;

  @JsonIgnore
  private String idSetting;
}
