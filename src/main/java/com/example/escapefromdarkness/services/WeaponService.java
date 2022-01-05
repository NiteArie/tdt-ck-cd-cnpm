package com.example.escapefromdarkness.services;

import com.example.escapefromdarkness.models.Weapon;
import com.example.escapefromdarkness.repositories.WeaponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WeaponService {
  private final WeaponRepository weaponRepository;

  public List<Weapon> findAll() {
    return weaponRepository.findAll();
  }

  public Weapon findOne(String id) {
    var weapon = weaponRepository.findById(id);
    if (weapon.isEmpty()) {
      return null;
    }
    return weapon.get();
  }
}
