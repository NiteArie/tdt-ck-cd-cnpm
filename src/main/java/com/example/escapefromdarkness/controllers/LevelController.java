package com.example.escapefromdarkness.controllers;

import com.example.escapefromdarkness.models.Level;
import com.example.escapefromdarkness.services.LevelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/levels")
@RequiredArgsConstructor
public class LevelController {
  private final LevelService levelService;

  @GetMapping()
  public ResponseEntity<List<Level>> findAll() {
    return ResponseEntity.ok(levelService.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Level> findOne(@PathVariable("id") String id) {
    return ResponseEntity.ok(levelService.findOne(id));
  }
}
