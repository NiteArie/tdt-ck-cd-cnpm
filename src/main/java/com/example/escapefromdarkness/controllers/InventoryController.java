package com.example.escapefromdarkness.controllers;

import com.example.escapefromdarkness.dto.InventoryCreateDto;
import com.example.escapefromdarkness.dto.InventoryUpdateDto;
import com.example.escapefromdarkness.exception.InvalidRequestException;
import com.example.escapefromdarkness.models.Inventory;
import com.example.escapefromdarkness.services.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

  @GetMapping("/users/{id}")
  public ResponseEntity<List<Inventory>> findAllOfUser(@PathVariable("id") String id) {
    return ResponseEntity.ok(inventoryService.findAllOfUser(id));
  }

//  @GetMapping("/{id}")
//  public ResponseEntity<Inventory> findOne(@PathVariable("id") String id) {
//    return ResponseEntity.ok(inventoryService.findOne(id));
//  }

//  @PostMapping()
//  public ResponseEntity<Inventory> create(@RequestBody InventoryCreateDto inventoryCreateDto) throws InvalidRequestException {
//    return ResponseEntity.ok(inventoryService.create(inventoryCreateDto));
//  }

  @PutMapping()
  public ResponseEntity<Inventory> update(@RequestBody InventoryUpdateDto inventoryUpdateDto) throws InvalidRequestException {
    return ResponseEntity.ok(inventoryService.update(inventoryUpdateDto));
  }
}
