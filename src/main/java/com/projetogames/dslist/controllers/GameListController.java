package com.projetogames.dslist.controllers;

import com.projetogames.dslist.dto.GameDTO;
import com.projetogames.dslist.dto.GameListDTO;
import com.projetogames.dslist.dto.GameMinDTO;
import com.projetogames.dslist.services.GameListService;
import com.projetogames.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/list")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping(value = "/{id}")
    public GameListDTO findById(@PathVariable Long id){
        return gameListService.findById(id);
    }

    @GetMapping
    public List<GameListDTO> findAll(){
        return gameListService.findAll();
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId){
        return gameService.findByList(listId);
    }
}
