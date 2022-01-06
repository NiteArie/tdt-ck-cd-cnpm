package com.example.escapefromdarkness.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Killed {
  @Id
  @GeneratedValue
  private Integer id;

  private String username;

  private String idEnemy;
}
