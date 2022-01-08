package com.example.escapefromdarkness.repositories;

import com.example.escapefromdarkness.models.Killed;
import com.example.escapefromdarkness.models.KilledId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KilledRepository extends JpaRepository<Killed, Integer> {
  long deleteByUsername(String username);

  List<Killed> findByUsername(String username);
}
