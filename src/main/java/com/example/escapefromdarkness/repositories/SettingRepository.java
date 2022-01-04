package com.example.escapefromdarkness.repositories;

import com.example.escapefromdarkness.models.Setting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SettingRepository extends JpaRepository<Setting, String> {
}
