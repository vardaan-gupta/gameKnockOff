package com.arena.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Game {
  
  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "created_at", nullable = false)
  private Date createdAt;
  
  @Column(name = "last_saved_at", nullable = true)
  private Date lastSavedAt;
  
  @ManyToOne
  @JoinColumn(name = "character_id")
  private Character character;

  public Game() {
    super();
  }

  public Game(Character character) {
    super();
    this.createdAt = new Date();
    this.lastSavedAt = null;
    this.character = character;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }
  
  public Date getLastSavedAt() {
    return lastSavedAt;
  }

  public void setLastSavedAt(Date lastSavedAt) {
    this.lastSavedAt = lastSavedAt;
  }
  
  public Character getCharacter() {
    return character;
  }

  public void setCharacter(Character character) {
    this.character = character;
  }

}
