package com.example.escapefromdarkness.controllers;

import com.example.escapefromdarkness.dto.game.GameSaveDto;
import com.example.escapefromdarkness.exception.InvalidRequestException;
import com.example.escapefromdarkness.services.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/games")
@RequiredArgsConstructor
public class GameController {
  private final GameService gameService;

  @PostMapping("/{id}")
  public ResponseEntity<Boolean> saveGame(@PathVariable("id") String username, @RequestBody GameSaveDto gameSaveDto) throws InvalidRequestException {
    return ResponseEntity.ok(gameService.saveGame(username, gameSaveDto));
  }
}
