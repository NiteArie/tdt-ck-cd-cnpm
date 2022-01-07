package com.example.escapefromdarkness.repositories;

import com.example.escapefromdarkness.models.PlayerSkill;
import com.example.escapefromdarkness.models.PlayerSkillId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerSkillRepository extends JpaRepository<PlayerSkill, PlayerSkillId> {
  List<PlayerSkill> findByUsername(String username);

  long deleteByUsername(String username);
}
