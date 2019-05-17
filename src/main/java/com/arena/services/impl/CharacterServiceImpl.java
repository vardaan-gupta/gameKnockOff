package com.arena.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.arena.entity.Character;
import com.arena.entity.Exploration;
import com.arena.exceptions.CharacterServiceException;
import com.arena.repository.CharacterRepository;
import com.arena.services.CharacterService;
import com.arena.services.ExplorationService;

@Component
public class CharacterServiceImpl implements CharacterService {

	@Autowired
	private CharacterRepository characterRepository;

	@Autowired
	private ExplorationService explorationService;

	public Character create(Character character) throws CharacterServiceException {
		if (character == null) {
			throw new CharacterServiceException("Character cannot be null");
		}
		if (character.getName() == null || character.getName().isEmpty()) {
			throw new CharacterServiceException("Character name cannot be empty");
		}
		return characterRepository.save(character);
	}

	public Character fight(Character character) {
		long coins = (int) (Math.random() * 100 + 1);
		character.setExperience(coins);
		System.out.print("You won a fight! You earned +" + coins + " Coins and some scars...");

		return characterRepository.save(character);
	}

	public Exploration explore(Character character) {
		Exploration exploration = explorationService.getRandomDiscoveryExploration();
		System.out.print("\n" + character.getName() + ", " + exploration.getMessage());

		return exploration;
	}

}