package com.example.escapefromdarkness.services;

import com.example.escapefromdarkness.models.Killed;
import com.example.escapefromdarkness.repositories.KilledRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KilledService {
  private final KilledRepository killedRepository;

  public List<Killed> findAll() {
    return killedRepository.findAll();
  }

  public Killed findOne(String id) {
    var killed = killedRepository.findById(id);
    if (killed.isEmpty()) {
      return null;
    }
    return killed.get();
  }
}
