package com.example.escapefromdarkness.controllers;

import com.example.escapefromdarkness.models.HP;
import com.example.escapefromdarkness.services.HPService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hps")
@RequiredArgsConstructor
public class HPController {
  private final HPService hpService;

  @GetMapping()
  public ResponseEntity<List<HP>> findAll() {
    return ResponseEntity.ok(hpService.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<HP> findOne(@PathVariable("id") String id) {
    return ResponseEntity.ok(hpService.findOne(id));
  }
}
