package com.arena;

import java.util.List;
import java.util.Scanner;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.arena.constants.GameConstants;
import com.arena.entity.Character;
import com.arena.entity.Game;
import com.arena.exceptions.CharacterServiceException;
import com.arena.exceptions.GameServiceException;
import com.arena.services.CharacterService;
import com.arena.services.GameService;

@Component
public class GameInitializer {

	@Autowired
	private GameService gameService;

	@Autowired
	private CharacterService characterService;

	private static Scanner in = new Scanner(System.in);

	@PostConstruct
	public void gameInit() {

		System.out.print("\n\n >>>>> " + " WELCOME TO THE GAME OF THRONES " + " <<<<<");
		System.out.print("\n\n Type the number of an option below to continue: ");
		System.out.print("\n 1  New Game");
		System.out.print("\n 2  Load Game");
		System.out.print("\n 9  Exit");
		System.out.print("\n\n > ");

		Integer option = in.nextInt();
		menuLoop: switch (option) {
		case GameConstants.NEW_GAME:
			System.out.print("\nType here the name of your new Character");
			System.out.print("\n\n > ");

			in.nextLine();
			String name = in.nextLine();

			try {
				Character character = new Character(name);
				Game game = gameService.createNewGame(character);
				System.out.print("\n " + name + " ! You are Ready to Begin \n");
				afterGameInitialised(game);
			} catch (CharacterServiceException e) {
				System.out.print("\n" + e.getMessage());
			}

			
			break;

		case GameConstants.LOAD_GAME:
			System.out.print("\nType the game ID you want to resume (example: 2)");

			try {
				List<Game> savedGames = gameService.getAllSavedGames();
				savedGames.forEach(g -> 
					System.out.println(
							"\n" + g.getId() + ". " + g.getCharacter().getName() + "(" + g.getCharacter().getCoins()
									+ "Coins), " + "created at: " + g.getCreatedAt().toString().replaceAll("T", ""))
				);

				System.out.print("\n\n > ");
				Integer optionGameID = in.nextInt();

				Game gameToResume = gameService.resumeGame(optionGameID.longValue());
				afterGameInitialised(gameToResume);

			} catch (GameServiceException e) {
				System.out.print("\n" + e.getMessage());
			}

			break;

		case GameConstants.EXIT_GAME:
			break menuLoop;

		default:
			System.out.print("\nYou typed an invalid option.");
			break;
		}
	}
	
	
	/**
	 * 
	 * @param game
	 */
	private void afterGameInitialised(Game game) {

		System.out.print("\n\nWelcome " + game.getCharacter().getName() + " !");
		System.out
				.print("\n\nYou have " + game.getCharacter().getCoins() + " Gold coins so far. Let's get some more!!!");
		subMenu: while (true) {
			System.out.print("\n Enter Your choice from Below :");

			System.out.print("\n 1 Explore the Seven Kingdoms");
			System.out.print("\n 2 Rage a War for the Iron Throne");
			System.out.print("\n 3 Save Current Game");
			System.out.print("\n 5 Quit");
			System.out.print("\n\n > ");

			Integer option = in.nextInt();
			switch (option) {
			case GameConstants.EXPLORE:
				characterService.explore(game.getCharacter());
				break;

			case GameConstants.FIGHT:
				characterService.fight(game.getCharacter());
				break;

			case GameConstants.SAVE:
				gameService.saveGame(game);
				System.out.print("\nGame saved");
				break;

			case GameConstants.QUIT:
				System.out.print("\nGood bye!");
				break subMenu;

			default:
				System.out.print("\nYou typed an invalid option." + "\n");
				continue;
			}
		}

	}
}
