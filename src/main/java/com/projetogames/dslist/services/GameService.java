package com.projetogames.dslist.services;

import com.projetogames.dslist.dto.GameDTO;
import com.projetogames.dslist.dto.GameMinDTO;
import com.projetogames.dslist.entities.Game;
import com.projetogames.dslist.projections.GameMinProjection;
import com.projetogames.dslist.repositories.GameRepository;
import com.projetogames.dslist.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
        Game result = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        return new GameDTO(result);
    }

    @Transactional(readOnly = true)
    public void deleteById(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    @Transactional(readOnly = true)
    public void update(Long id, GameDTO game) {
        Game gameOptional = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        BeanUtils.copyProperties(game, gameOptional);
        repository.save(gameOptional);
    }

    public GameDTO insert(Game game){
        return new GameDTO(repository.save(game));
    }
}
