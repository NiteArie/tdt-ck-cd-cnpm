package com.example.escapefromdarkness.services;

import com.example.escapefromdarkness.dto.game.GameSaveDto;
import com.example.escapefromdarkness.exception.InvalidRequestException;
import com.example.escapefromdarkness.models.DevilFruit;
import com.example.escapefromdarkness.models.Inventory;
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

    return Boolean.TRUE;
  }
}
