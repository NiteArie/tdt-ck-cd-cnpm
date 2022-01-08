package com.example.escapefromdarkness.dto.game;

import lombok.Data;

import java.util.List;

@Data
public class GameSaveDto {
  private String username;

  private int coin;

  private int currentHealth;

  private int currentMana;

  private double x;

  private double y;

  private Integer idLevel;

  private List<GameSaveInventoryDto> inventory;

  private GameSaveSettingDto setting;

  private List<GameSaveDevilFruitDto> devilFruit;

  private List<GameSaveSkillDto> skill;

  private List<GameSaveKilledDto> enemy;
}
