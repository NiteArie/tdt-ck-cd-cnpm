package com.example.escapefromdarkness.models;

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

  @OneToOne
  @JoinColumn(name = "idLevel")
  private Level level;

  private int coin;

  private int currentHealth;

  private int currentMana;

  private double x;

  private double y;

  @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
  Set<Killed> killedSet = new HashSet<>();

  @OneToOne
  @JoinColumn(name = "idSetting")
  private Setting setting;


  @OneToOne
  @JoinColumn(name = "idSkill")
  private Skill skill;
}
