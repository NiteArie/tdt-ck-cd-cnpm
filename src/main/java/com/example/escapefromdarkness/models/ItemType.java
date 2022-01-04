package com.example.escapefromdarkness.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class ItemType {
  @Id
  @GeneratedValue
  private int id;

  private String name;

}
