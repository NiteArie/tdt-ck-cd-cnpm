package com.example.escapefromdarkness.controllers;

import com.example.escapefromdarkness.models.Skill;
import com.example.escapefromdarkness.services.SkillService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/skills")
@AllArgsConstructor
public class SkillController {

  private final SkillService skillService;

  @GetMapping()
  public ResponseEntity<List<Skill>> findAll() {
    return ResponseEntity.ok(skillService.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Skill> find(@PathVariable("id") String id) {
    return ResponseEntity.ok(skillService.findOne(id));
  }
}
