package com.example.escapefromdarkness.services;

import com.example.escapefromdarkness.models.ItemType;
import com.example.escapefromdarkness.repositories.ItemTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemTypeService {
  private final ItemTypeRepository itemTypeRepository;

  public List<ItemType> findAll() {
    return itemTypeRepository.findAll();
  }

  public ItemType findOne(String id) {
    var itemType = itemTypeRepository.findById(Integer.parseInt(id));
    if (itemType.isEmpty()) {
      return null;
    }
    return itemType.get();
  }
}
