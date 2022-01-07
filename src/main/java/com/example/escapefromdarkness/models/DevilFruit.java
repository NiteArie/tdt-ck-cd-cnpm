package com.example.escapefromdarkness.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Data
@Entity
@IdClass(DevilFruitId.class)
@AllArgsConstructor
@RequiredArgsConstructor
public class DevilFruit {
  @Id
  private Integer id;

  @Id
  private String username;
}
