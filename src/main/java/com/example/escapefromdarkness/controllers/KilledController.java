package com.example.escapefromdarkness.controllers;

import com.example.escapefromdarkness.models.Killed;
import com.example.escapefromdarkness.services.KilledService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/killeds")
@RequiredArgsConstructor
public class KilledController {
  private final KilledService killedService;

  @GetMapping()
  public ResponseEntity<List<Killed>> findAll() {
    return ResponseEntity.ok(killedService.findAll());
  }

//  @GetMapping("/{id}")
//  public ResponseEntity<Killed> findOne(@PathVariable("id") String id) {
//    return ResponseEntity.ok(killedService.findOne(id));
//  }
}
