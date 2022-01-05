package com.example.escapefromdarkness.services;

import com.example.escapefromdarkness.models.Inventory;
import com.example.escapefromdarkness.repositories.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {
  private final InventoryRepository inventoryRepository;

  public List<Inventory> findAll() {
    return inventoryRepository.findAll();
  }

  public Inventory findOne(String id) {
    var inventory = inventoryRepository.findById(id);
    if (inventory.isEmpty()) {
      return null;
    }
    return inventory.get();
  }
}
