package com.example.escapefromdarkness.repositories;

import com.example.escapefromdarkness.models.Enemy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnemyRepository extends JpaRepository<Enemy, Integer> {
}
