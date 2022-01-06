package com.example.escapefromdarkness.services;

import com.example.escapefromdarkness.models.Item;
import com.example.escapefromdarkness.repositories.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {
  private final ItemRepository itemRepository;

  public List<Item> findAll() {
    return itemRepository.findAll();
  }

  public Item findOne(String id) {
    var item = itemRepository.findById(id);
    if (item.isEmpty()) {
      return null;
    }
    return item.get();
  }
}
