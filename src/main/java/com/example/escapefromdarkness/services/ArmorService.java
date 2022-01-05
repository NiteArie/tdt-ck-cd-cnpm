package com.example.escapefromdarkness.services;

import com.example.escapefromdarkness.models.Armor;
import com.example.escapefromdarkness.repositories.ArmorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArmorService {
  private final ArmorRepository armorRepository;

  public List<Armor> findAll() {
    return armorRepository.findAll();
  }

  public Armor findOne(String id) {
    var armor = armorRepository.findById(id);
    if (armor.isEmpty()) {
      return null;
    }
    return armor.get();
  }
}
