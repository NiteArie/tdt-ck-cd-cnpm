package com.example.escapefromdarkness.controllers;

import com.example.escapefromdarkness.models.Inventory;
import com.example.escapefromdarkness.services.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/inventories")
@RequiredArgsConstructor
public class InventoryController {
  private final InventoryService inventoryService;

  @GetMapping()
  public ResponseEntity<List<Inventory>> findAll() {
    return ResponseEntity.ok(inventoryService.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Inventory> findOne(@PathVariable("id") String id) {
    return ResponseEntity.ok(inventoryService.findOne(id));
  }
}
