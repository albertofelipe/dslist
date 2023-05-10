package com.projetogames.dslist.services;

import com.projetogames.dslist.dto.GameDTO;
import com.projetogames.dslist.dto.GameMinDTO;
import com.projetogames.dslist.entities.Game;
import com.projetogames.dslist.projections.GameMinProjection;
import com.projetogames.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    GameRepository repository;

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        var result = repository.findAll();
        return result.stream().map(x -> new GameMinDTO(x)).toList();
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId) {
        List <GameMinProjection> result = repository.searchByList(listId);
        return result.stream().map(x -> new GameMinDTO(x)).toList();
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id){
        Game result = repository.findById(id).get();
        return new GameDTO(result);
    }

}
