package com.arena.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arena.entity.Game;

public interface GameRepository extends JpaRepository<Game, Long>{

	
}
