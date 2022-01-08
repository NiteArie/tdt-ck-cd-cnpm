package com.example.escapefromdarkness.services;

import com.example.escapefromdarkness.dto.game.GameSaveDto;
import com.example.escapefromdarkness.exception.InvalidRequestException;
import com.example.escapefromdarkness.models.DevilFruit;
import com.example.escapefromdarkness.models.Inventory;
import com.example.escapefromdarkness.models.Killed;
import com.example.escapefromdarkness.models.PlayerSkill;
import com.example.escapefromdarkness.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GameService {
  private final AccountRepository accountRepository;
  private final InventoryRepository inventoryRepository;
  private final SettingRepository settingRepository;
  private final DevilFruitRepository devilFruitRepository;
  private final PlayerSkillRepository playerSkillRepository;
  private final KilledRepository killedRepository;
  private final LevelRepository levelRepository;

  @Transactional
  public Boolean saveGame(String username, GameSaveDto gameSaveDto) throws InvalidRequestException {
    if (!username.equals(gameSaveDto.getUsername())) {
      throw new InvalidRequestException("Username must be the same to be able to save");
    }

    var account = accountRepository.findById(username);
    if (account.isEmpty()) {
      throw new InvalidRequestException(String.format("Account with username (%s) doesn't exist", username));
    }

    account.get().setCoin(gameSaveDto.getCoin());
    account.get().setCurrentHealth(gameSaveDto.getCurrentHealth());
    account.get().setCurrentMana(gameSaveDto.getCurrentMana());
    account.get().setX(gameSaveDto.getX());
    account.get().setY(gameSaveDto.getY());
    account.get().setIdLevel(gameSaveDto.getIdLevel());

    accountRepository.save(account.get());

    var setting = settingRepository.findById(username);

    setting.get().setVolume(gameSaveDto.getSetting().getVolume());
    setting.get().setHasMusic(gameSaveDto.getSetting().isHasMusic());
    setting.get().setHasEffect(gameSaveDto.getSetting().isHasEffect());

    settingRepository.save(setting.get());

    inventoryRepository.deleteByUsername(username);

    var newInventories = gameSaveDto.getInventory().stream().map(inventory -> {
      var newInventory = new Inventory();
      newInventory.setUsername(username);
      newInventory.setIdItem(inventory.getIdItem());
      newInventory.setQuantity(inventory.getQuantity());
      return newInventory;
    }).collect(Collectors.toList());

    inventoryRepository.saveAll(newInventories);

    var newDevilFruits = gameSaveDto.getDevilFruit().stream().map(devilFruit -> {
      var newDevilFruit = new DevilFruit();
      newDevilFruit.setId(devilFruit.getId());
      newDevilFruit.setUsername(username);
      return newDevilFruit;
    }).collect(Collectors.toList());

    devilFruitRepository.saveAll(newDevilFruits);

    playerSkillRepository.deleteByUsername(username);

    var newSkills = gameSaveDto.getSkill().stream().map(skill -> {
      var newSkill = new PlayerSkill();
      newSkill.setIdSkill(skill.getId());
      newSkill.setUsername(username);
      return newSkill;
    }).collect(Collectors.toList());

    playerSkillRepository.saveAll(newSkills);

    killedRepository.deleteByUsername(username);

    var newEnemies = gameSaveDto.getEnemy().stream().map(enemy -> {
      var newEnemy = new Killed();
      newEnemy.setIdEnemy(enemy.getId());
      newEnemy.setUsername(username);
      return newEnemy;
    }).collect(Collectors.toList());

    killedRepository.saveAll(newEnemies);

    return Boolean.TRUE;
  }

  @Transactional
  public Boolean newGame(String username) throws InvalidRequestException {
    var account = accountRepository.findById(username);
    if (account.isEmpty()) {
      throw new InvalidRequestException(String.format("Account with username (%s) doesn't exist", username));
    }

    account.get().setCoin(200);
    account.get().setCurrentHealth(1000);
    account.get().setCurrentMana(1000);
    account.get().setX(10.0);
    account.get().setY(-6.0);

    var level = levelRepository.findById(1);
    if (level.isPresent()) {
      account.get().setIdLevel(1);
    }

    accountRepository.save(account.get());

    inventoryRepository.deleteByUsername(username);

    devilFruitRepository.deleteByUsername(username);

    playerSkillRepository.deleteByUsername(username);

    killedRepository.deleteByUsername(username);

    return Boolean.TRUE;
  }
}
