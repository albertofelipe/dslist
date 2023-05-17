package com.projetogames.dslist.controllers;

import com.projetogames.dslist.dto.GameDTO;
import com.projetogames.dslist.dto.GameListDTO;
import com.projetogames.dslist.dto.GameMinDTO;
import com.projetogames.dslist.dto.ReplacementDTO;
import com.projetogames.dslist.services.GameListService;
import com.projetogames.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/list")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<GameListDTO> findById(@PathVariable Long id){
         GameListDTO gameList = gameListService.findById(id);
         return ResponseEntity.ok().body(gameList);
    }

    @GetMapping
    public ResponseEntity<List<GameListDTO>> findAll(){
        var list = gameListService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{listId}/games")
    public ResponseEntity<List<GameMinDTO>> findByList(@PathVariable Long listId){
        var list = gameService.findByList(listId);
        return ResponseEntity.ok().body(list);
    }

    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body){
        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }
}
