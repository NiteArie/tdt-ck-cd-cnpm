package com.example.escapefromdarkness.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Item {
  @Id
  @GeneratedValue
  private String id;

  private int idType;

  private int idSubtype;
}
