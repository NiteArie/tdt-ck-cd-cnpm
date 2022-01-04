package com.example.escapefromdarkness.repositories;

import com.example.escapefromdarkness.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
