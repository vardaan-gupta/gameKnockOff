package com.arena.services;

import com.arena.exceptions.CharacterServiceException;
import com.arena.entity.Exploration;
import com.arena.entity.Character;

public interface CharacterService {

	 Character create(Character character) throws CharacterServiceException;
	  
	  Character fight(Character character);
	  
	  Exploration explore(Character character);

}
