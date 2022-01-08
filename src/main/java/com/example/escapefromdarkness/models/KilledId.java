package com.example.escapefromdarkness.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
public class KilledId implements Serializable {
  private String username;
  private Integer idEnemy;
}
