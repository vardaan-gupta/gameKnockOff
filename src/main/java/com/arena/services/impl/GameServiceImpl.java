package com.arena.services.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arena.entity.Character;
import com.arena.entity.Game;
import com.arena.exceptions.GameServiceException;
import com.arena.repository.GameRepository;
import com.arena.services.CharacterService;
import com.arena.services.GameService;

@Service
public class GameServiceImpl implements GameService{
	
	@Autowired
	private CharacterService characterService;
	
	@Autowired
	private GameRepository gameRepository;
	

	public Game createNewGame(Character character) {
		 characterService.create(character);
		    Game game = new Game(character);
		    return gameRepository.save(game);
	}

	public Game saveGame(Game game) {
	    if (game == null) {
	        throw new GameServiceException("Only Night King can be Null. Game cannot be null");
	      }
	      game.setLastSavedAt(new Date());
	      return gameRepository.save(game);
	}

	public Game resumeGame(Long id) throws GameServiceException {
		 Optional<Game> game = gameRepository.findById(id);
		    if (! game.isPresent()) {
		      throw new GameServiceException("Game not found with ID: " + id);
		    }
		    return game.get();
	}

	public List<Game> getAllSavedGames() throws GameServiceException {
		List<Game> games = gameRepository.findAll();
	    if (games.isEmpty()) {
	      throw new GameServiceException("No saved games were found");
	    }
	    return games;
	}

}
