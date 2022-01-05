package com.example.escapefromdarkness.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
public class ErrorMessage {
  private UUID id = UUID.randomUUID();

  private String message;

  public ErrorMessage(String message) {
    this.message = message;
  }
}
