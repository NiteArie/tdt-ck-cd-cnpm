package com.example.escapefromdarkness.controllers;

import com.example.escapefromdarkness.models.MP;
import com.example.escapefromdarkness.services.MPService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mps")
@RequiredArgsConstructor
public class MPController {
  private final MPService mpService;

  @GetMapping()
  public ResponseEntity<List<MP>> findAll() {
    return ResponseEntity.ok(mpService.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<MP> findOne(@PathVariable("id") String id) {
    return ResponseEntity.ok(mpService.findOne(id));
  }
}
