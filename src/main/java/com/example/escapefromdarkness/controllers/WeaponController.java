package com.example.escapefromdarkness.controllers;

import com.example.escapefromdarkness.models.Weapon;
import com.example.escapefromdarkness.services.WeaponService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/weapons")
@RequiredArgsConstructor
public class WeaponController {
  private final WeaponService weaponService;

  @GetMapping()
  public ResponseEntity<List<Weapon>> findAll() {
    return ResponseEntity.ok(weaponService.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Weapon> findOne(@PathVariable("id") String id) {
    return ResponseEntity.ok(weaponService.findOne(id));
  }
}
