package com.example.escapefromdarkness.services;

import com.example.escapefromdarkness.models.Level;
import com.example.escapefromdarkness.repositories.LevelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LevelService {
  private final LevelRepository levelRepository;

  public List<Level> findAll() {
    return levelRepository.findAll();
  }

  public Level findOne(String id) {
    var level = levelRepository.findById(id);
    if (level.isEmpty()) {
      return null;
    }
    return level.get();
  }
}
