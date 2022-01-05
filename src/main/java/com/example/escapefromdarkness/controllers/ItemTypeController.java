package com.example.escapefromdarkness.controllers;

import com.example.escapefromdarkness.models.ItemType;
import com.example.escapefromdarkness.services.ItemTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/item-types")
@RequiredArgsConstructor
public class ItemTypeController {
  private final ItemTypeService itemTypeService;

  @GetMapping()
  public ResponseEntity<List<ItemType>> findAll() {
    return ResponseEntity.ok(itemTypeService.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<ItemType> findOne(@PathVariable("id") String id) {
    return ResponseEntity.ok(itemTypeService.findOne(id));
  }
}
