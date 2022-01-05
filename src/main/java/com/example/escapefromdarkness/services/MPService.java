package com.example.escapefromdarkness.services;

import com.example.escapefromdarkness.models.MP;
import com.example.escapefromdarkness.repositories.MPRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MPService {
  private final MPRepository mpRepository;

  public List<MP> findAll() {
    return mpRepository.findAll();
  }

  public MP findOne(String id) {
    var mp = mpRepository.findById(id);
    if (mp.isEmpty()) {
      return null;
    }
    return mp.get();
  }
}
