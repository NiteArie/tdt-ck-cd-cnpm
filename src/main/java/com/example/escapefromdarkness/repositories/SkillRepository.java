package com.example.escapefromdarkness.repositories;

import com.example.escapefromdarkness.models.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillRepository extends JpaRepository<Skill, String> {
  List<Skill> findByUsername(String username);
}
