package com.example.escapefromdarkness.repositories;

import com.example.escapefromdarkness.models.Level;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LevelRepository extends JpaRepository<Level, String> {
}
