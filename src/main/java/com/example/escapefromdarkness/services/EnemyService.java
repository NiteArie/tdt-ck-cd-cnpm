package com.example.escapefromdarkness.services;

import com.example.escapefromdarkness.models.Enemy;
import com.example.escapefromdarkness.repositories.EnemyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnemyService {
  private final EnemyRepository enemyRepository;

  public List<Enemy> findAll() {
    return enemyRepository.findAll();
  }

  public Enemy findOne(String id) {
    var enemy = enemyRepository.findById(Integer.parseInt(id));
    if (enemy.isEmpty()) {
      return null;
    }
    return enemy.get();
  }
}
