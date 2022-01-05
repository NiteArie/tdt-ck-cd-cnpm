package com.example.escapefromdarkness.services;

import com.example.escapefromdarkness.models.HP;
import com.example.escapefromdarkness.repositories.HPRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HPService {
  private final HPRepository hpRepository;

  public List<HP> findAll() {
    return hpRepository.findAll();
  }

  public HP findOne(String id) {
    var hp = hpRepository.findById(id);
    if (hp.isEmpty()) {
      return null;
    }
    return hp.get();
  }
}
