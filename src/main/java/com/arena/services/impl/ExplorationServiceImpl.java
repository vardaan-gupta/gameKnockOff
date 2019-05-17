package com.arena.services.impl;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.arena.entity.Exploration;
import com.arena.factory.ExplorationFactory;
import com.arena.services.ExplorationService;

@Component
public class ExplorationServiceImpl implements ExplorationService {
  
  @Autowired
  private ExplorationFactory  explorationFactory;

  @Override
  public Exploration getRandomDiscoveryExploration() {
    List<Exploration> explorations =  explorationFactory.exploreWesteros();
    Random rand = new Random();
    return explorations.get(rand.nextInt(explorations.size() - 1));
  }

  @Override
  public List<Exploration> getAll() {
    return explorationFactory.exploreWesteros();
  }

}
