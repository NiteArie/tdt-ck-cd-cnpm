package com.example.escapefromdarkness.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class HP {
  @Id
  private String id;

  private String name;

  @Column(length = 2000)
  private String description;

  @Column(length = 2000)
  private String slug;

  private int price;

  private int rateHP;
}
