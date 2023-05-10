package com.projetogames.dslist.services;

import com.projetogames.dslist.dto.GameListDTO;
import com.projetogames.dslist.entities.Game;
import com.projetogames.dslist.entities.GameList;
import com.projetogames.dslist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    GameListRepository repository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> result = repository.findAll();
        return result.stream().map(x -> new GameListDTO(x)).toList();
    }

    @Transactional(readOnly = true)
    public GameListDTO findById(Long id){
        GameList result = repository.findById(id).get();
        return new GameListDTO(result);
    }
}
