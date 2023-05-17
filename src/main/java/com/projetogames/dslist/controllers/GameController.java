package com.projetogames.dslist.controllers;

import com.projetogames.dslist.dto.GameDTO;
import com.projetogames.dslist.dto.GameMinDTO;
import com.projetogames.dslist.entities.Game;
import com.projetogames.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    private GameService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity <GameDTO> findById(@PathVariable Long id){
        GameDTO game = service.findById(id);
        return ResponseEntity.ok().body(game);
    }

    @GetMapping
    public ResponseEntity<List<GameMinDTO>> findAll() {
        List<GameMinDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
