package com.arena.services;

import java.util.List;

import com.arena.entity.Character;
import com.arena.entity.Game;
import com.arena.exceptions.GameServiceException;

public interface GameService {

	Game createNewGame(Character character);

	Game saveGame(Game game);

	Game resumeGame(Long id) throws GameServiceException;

	List<Game> getAllSavedGames() throws GameServiceException;

}
