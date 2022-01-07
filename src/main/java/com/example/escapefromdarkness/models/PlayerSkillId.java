package com.example.escapefromdarkness.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
public class PlayerSkillId implements Serializable {
  private String idSkill;
  private String username;
}
