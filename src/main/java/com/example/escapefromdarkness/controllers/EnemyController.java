package com.example.escapefromdarkness.controllers;

import com.example.escapefromdarkness.models.Armor;
import com.example.escapefromdarkness.models.Enemy;
import com.example.escapefromdarkness.services.ArmorService;
import com.example.escapefromdarkness.services.EnemyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/enemies")
@RequiredArgsConstructor
public class EnemyController {
  private final EnemyService enemyService;

  @GetMapping()
  public ResponseEntity<List<Enemy>> findAll() {
    return ResponseEntity.ok(enemyService.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Enemy> findOne(@PathVariable("id") String id) {
    return ResponseEntity.ok(enemyService.findOne(id));
  }
}
