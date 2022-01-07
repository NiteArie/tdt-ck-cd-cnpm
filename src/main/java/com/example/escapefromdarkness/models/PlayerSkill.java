package com.example.escapefromdarkness.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@Data
@RequiredArgsConstructor
@IdClass(PlayerSkillId.class)
public class PlayerSkill {

  @Id
  private String idSkill;

  @Id
  private String username;
}
