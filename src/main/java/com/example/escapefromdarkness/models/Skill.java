package com.example.escapefromdarkness.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Skill {
  @Id
  @Column(name = "id")
  private String id;

  private String name;

  private String description;

  private int mana;
}
