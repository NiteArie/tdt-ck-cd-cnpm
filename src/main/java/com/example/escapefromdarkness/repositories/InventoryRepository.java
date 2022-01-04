package com.example.escapefromdarkness.repositories;

import com.example.escapefromdarkness.models.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, String> {
}
