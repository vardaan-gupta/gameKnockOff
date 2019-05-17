package com.arena.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.arena.GameServiceTest;
import com.arena.entity.Character;
import com.arena.entity.Exploration;
import com.arena.exceptions.CharacterServiceException;
import com.arena.repository.CharacterRepository;
import com.arena.services.impl.CharacterServiceImpl;




public class CharacterServiceTest extends GameServiceTest{
	
  
  @MockBean
  private CharacterRepository characterRepo;
  
  @InjectMocks
  @Autowired
  private CharacterServiceImpl characterService;
  
  @Test(expected=CharacterServiceException.class)
  public void testErrorCreateCharacterWhenCharacterNameNull() {
    Character character = new Character();
    character = characterService.create(character);
  }
  
  @Test(expected=CharacterServiceException.class)
  public void testThrowErrorForCreateCharacterWhenCharacterIsNull() throws CharacterServiceException {
	  Character character = null;
	  character = characterService.create(character);
  }
  
  @Test(expected=CharacterServiceException.class)
  public void testErrorCreateCharacterWhenNameIsEmpty() throws CharacterServiceException {
     
    Character character = new Character("");
    character = characterService.create(character);
  }
  
 
 
  @Test
  public void testCoinsNotZeroForNewCharacter() {
    Character character = new Character("JohnSnow-Who knows Nothing !");
    characterService.create(character);
    assertEquals("A new character must have zero experience", character.getCoins(), 0);
    
   
  }
  
  @Test
  public void testSuccessWhenExploring() {
    Character character = new Character("");
    Exploration exploration = characterService.explore(character);
    
    assertNotNull("A message must exist when a character explores", exploration.getMessage());
  }

}
