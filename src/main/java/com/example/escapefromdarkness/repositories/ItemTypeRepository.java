package com.example.escapefromdarkness.repositories;

import com.example.escapefromdarkness.models.ItemType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemTypeRepository extends JpaRepository<ItemType, Integer> {
}
