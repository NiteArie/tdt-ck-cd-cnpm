package com.example.escapefromdarkness.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Killed {
  @Id
  @GeneratedValue
  private Integer id;
  
  @ManyToOne
  @JoinColumn(name = "username")
  private Account account;


  @OneToOne
  @JoinColumn(name = "idEnemy")
  private Enemy enemy;
}
