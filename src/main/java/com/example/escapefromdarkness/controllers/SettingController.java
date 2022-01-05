package com.example.escapefromdarkness.controllers;

import com.example.escapefromdarkness.models.Setting;
import com.example.escapefromdarkness.services.SettingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/settings")
@RequiredArgsConstructor
public class SettingController {
  private final SettingService settingService;

  @GetMapping()
  public ResponseEntity<List<Setting>> findAll() {
    return ResponseEntity.ok(settingService.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Setting> findOne(@PathVariable("id") String id) {
    return ResponseEntity.ok(settingService.findOne(id));
  }
}
