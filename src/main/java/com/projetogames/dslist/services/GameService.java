package com.projetogames.dslist.services;

import com.projetogames.dslist.dto.GameMinDTO;
import com.projetogames.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    GameRepository repository;

    public List<GameMinDTO> findAll() {
        var result = repository.findAll();
        return result.stream().map(x -> new GameMinDTO(x)).toList();
    }
}
