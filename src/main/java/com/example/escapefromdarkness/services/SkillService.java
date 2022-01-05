package com.example.escapefromdarkness.services;

import com.example.escapefromdarkness.models.Skill;
import com.example.escapefromdarkness.repositories.SkillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SkillService {
  private final SkillRepository skillRepository;

  public List<Skill> findAll() {
    return skillRepository.findAll();
  }

  public Skill findOne(String id) {
    var skill = skillRepository.findById(id);
    if (skill.isEmpty()) {
      return null;
    }
    return skill.get();
  }
}
