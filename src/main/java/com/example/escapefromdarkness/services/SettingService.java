package com.example.escapefromdarkness.services;

import com.example.escapefromdarkness.models.Setting;
import com.example.escapefromdarkness.repositories.SettingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SettingService {
  private final SettingRepository settingRepository;

  public List<Setting> findAll() {
    return settingRepository.findAll();
  }

  public Setting findOne(String id) {
    var setting = settingRepository.findById(id);
    if (setting.isEmpty()) {
      return null;
    }
    return setting.get();
  }
}
