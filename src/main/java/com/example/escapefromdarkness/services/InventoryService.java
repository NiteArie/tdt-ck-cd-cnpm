package com.example.escapefromdarkness.services;

import com.example.escapefromdarkness.dto.InventoryCreateDto;
import com.example.escapefromdarkness.dto.InventoryUpdateDto;
import com.example.escapefromdarkness.exception.InvalidRequestException;
import com.example.escapefromdarkness.models.Inventory;
import com.example.escapefromdarkness.models.InventoryId;
import com.example.escapefromdarkness.repositories.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {
  private final InventoryRepository inventoryRepository;

  public List<Inventory> findAll() {
    return inventoryRepository.findAll();
  }

  public List<Inventory> findAllOfUser(String id) {
    List<String> ids = new ArrayList<>();
    ids.add(id);

    var inventories = inventoryRepository.findByUsername(id);
    return inventories;
  }


  public Inventory create(InventoryCreateDto inventoryCreateDto) throws InvalidRequestException {
    Inventory inventory = new Inventory();
//    Inventory inventory = new Inventory(
//      inventoryCreateDto.getUsername(),
//      inventoryCreateDto.getIdItem(),
//      inventoryCreateDto.getQuantity()
//    );
    inventory.setUsername(inventoryCreateDto.getUsername());
    inventory.setQuantity(inventoryCreateDto.getQuantity());
    inventory.setIdItem(inventoryCreateDto.getIdItem());

    return inventoryRepository.save(inventory);
  }

  public Inventory update(InventoryUpdateDto inventoryUpdateDto) throws InvalidRequestException {
    var inventory = inventoryRepository.findById(new InventoryId(inventoryUpdateDto.getUsername(), inventoryUpdateDto.getIdItem()));
    if (inventory.isEmpty()) {
      Inventory newInventory = new Inventory();
      newInventory.setUsername(inventoryUpdateDto.getUsername());
      newInventory.setQuantity(inventoryUpdateDto.getQuantity());
      newInventory.setIdItem(inventoryUpdateDto.getIdItem());
      return inventoryRepository.save(newInventory);
    }
    if (!inventory.get().getUsername().equals(inventoryUpdateDto.getUsername())) {
      throw new InvalidRequestException("User inventory to be updated must be the same");
    }

    inventory.get().setIdItem(inventoryUpdateDto.getIdItem());
    inventory.get().setUsername(inventoryUpdateDto.getUsername());
    inventory.get().setQuantity(inventoryUpdateDto.getQuantity());

    return inventoryRepository.save(inventory.get());
  }
}
