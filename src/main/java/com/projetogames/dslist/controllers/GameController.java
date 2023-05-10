package com.projetogames.dslist.controllers;

import com.projetogames.dslist.dto.GameDTO;
import com.projetogames.dslist.dto.GameMinDTO;
import com.projetogames.dslist.entities.Game;
import com.projetogames.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    private GameService service;

    @GetMapping(value = "/{id}")
    public GameDTO findById(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping
    public List<GameMinDTO> findAll() {
         return service.findAll();
    }
}
