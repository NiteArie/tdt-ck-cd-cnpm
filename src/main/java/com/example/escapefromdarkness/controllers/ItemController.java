package com.example.escapefromdarkness.controllers;

import com.example.escapefromdarkness.models.Item;
import com.example.escapefromdarkness.services.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemController {
  private final ItemService itemService;

  @GetMapping()
  public ResponseEntity<List<Item>> findAll() {
    return ResponseEntity.ok(itemService.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Item> findOne(@PathVariable("id") String id) {
    return ResponseEntity.ok(itemService.findOne(id));
  }
}
