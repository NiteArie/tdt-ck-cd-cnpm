package com.example.escapefromdarkness.repositories;

import com.example.escapefromdarkness.models.Inventory;
import com.example.escapefromdarkness.models.InventoryId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory, InventoryId> {

  List<Inventory> findByUsername(String username);

  long deleteByUsername(String username);
}
