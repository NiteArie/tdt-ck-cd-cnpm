package com.example.escapefromdarkness.controllers;

import com.example.escapefromdarkness.models.Armor;
import com.example.escapefromdarkness.services.ArmorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/armors")
@RequiredArgsConstructor
public class ArmorController {
  private final ArmorService armorService;

  @GetMapping()
  public ResponseEntity<List<Armor>> findAll() {
    return ResponseEntity.ok(armorService.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Armor> findOne(@PathVariable("id") String id) {
    return ResponseEntity.ok(armorService.findOne(id));
  }
}
