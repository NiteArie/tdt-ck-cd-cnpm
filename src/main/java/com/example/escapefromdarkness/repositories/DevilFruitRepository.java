package com.example.escapefromdarkness.repositories;

import com.example.escapefromdarkness.models.DevilFruit;
import com.example.escapefromdarkness.models.DevilFruitId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DevilFruitRepository extends JpaRepository<DevilFruit, DevilFruitId> {
  List<DevilFruit> findByUsername(String username);
}
