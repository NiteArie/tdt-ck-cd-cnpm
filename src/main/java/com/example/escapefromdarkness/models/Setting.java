package com.example.escapefromdarkness.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Setting {
  @Id
  @Column(name = "username")
  private String username;

  private int volume;

  private boolean hasEffect;

  private boolean hasMusic;
}
