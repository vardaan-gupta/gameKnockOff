package com.arena.services;

import java.util.List;

import com.arena.entity.Exploration;

public interface ExplorationService {

	Exploration getRandomDiscoveryExploration();

	List<Exploration> getAll();

}
