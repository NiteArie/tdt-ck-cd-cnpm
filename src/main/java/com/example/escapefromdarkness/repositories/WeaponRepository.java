package com.example.escapefromdarkness.repositories;

import com.example.escapefromdarkness.models.Weapon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeaponRepository extends JpaRepository<Weapon, String> {
}
