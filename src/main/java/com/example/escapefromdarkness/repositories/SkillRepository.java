package com.example.escapefromdarkness.repositories;

import com.example.escapefromdarkness.models.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, String> {
}
