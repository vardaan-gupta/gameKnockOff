package com.arena.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "character_")
public class Character {
	
  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  
  @Column(name = "name", nullable = false)
  private String name;
  
  @Column(name = "coins", nullable = false)
  private long coins;
  
  public Character() {
    super();
  }

  public Character(String name) {
    super();
    this.name = name;
    this.coins = 0;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  
  public long getCoins() {
    return coins;
  }

  public void setExperience(long coins) {
    this.coins += coins;
  }

}
