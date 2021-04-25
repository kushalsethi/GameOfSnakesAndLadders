package com.kushals.snakesandladders.starter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.kushals.snakesandladders.enums.DiceTypes;
import com.kushals.snakesandladders.model.Player;
import com.kushals.snakesandladders.model.Snake;
import com.kushals.snakesandladders.service.GameService;
import com.kushals.snakesandladders.service.GameServiceImpl;

public class GameStarter {

	private static int GAME_BOARD_SIZE = 100;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Game of Snakes and Ladders [Board Size = 100]");
		int numOfPlayer;
		do {
			System.out.println("Enter number of players for the game. (Positive number)");
			while (!sc.hasNextInt()) {
				System.out.println("That's not a number!, please enter again");
				sc.next();
			}
			numOfPlayer = sc.nextInt();
		} while (numOfPlayer <= 0);

		List<Player> players = new ArrayList<>();
		for (int i = 1; i <= numOfPlayer; i++) {
			System.out.println("Enter name for the player " + i);
			players.add(new Player(sc.next()));
		}

		int numOfSnakes;
		do {
			System.out.println("Enter number of snakes for the game. (Positive number between 1 to 20)");
			while (!sc.hasNextInt()) {
				System.out.println("That's not a number!, please enter again");
				sc.next();
			}
			numOfSnakes = sc.nextInt();
		} while (numOfSnakes <= 0 || numOfSnakes > 20);

		List<Snake> snakes = new ArrayList<>();
		Map<Integer, Snake> snakesPositions = new HashMap<>();
		for (int i = 1; i <= numOfSnakes; i++) {
			int start, end;
			do {
				System.out.println("Enter the start position for snake " + i
						+ " (Positive number between 2 to 99, and not a duplicate snake with same start position)");
				while (!sc.hasNextInt()) {
					System.out.println("That's not a number!, please enter again");
					sc.next();
				}
				start = sc.nextInt();
			} while (start <= 1 || start > 99 || snakesPositions.containsKey(start));

			do {
				System.out.println("Enter the end position for snake " + i + " (strictly between 1 and " + (start - 1)
						+ " position)");
				while (!sc.hasNextInt()) {
					System.out.println("That's not a number!, please enter again");
					sc.next();
				}
				end = sc.nextInt();
			} while (end < 1 || end >= start);

			Snake snake = new Snake(start, end);
			snakes.add(snake);
			snakesPositions.put(start, snake);
		}

		System.out.println("Available Dice Types:");
		List<DiceTypes> diceTypes = Arrays.asList(DiceTypes.values());
		diceTypes.forEach(System.out::println);
		sc.nextLine(); // ignore the leftover of the previous input

		for (int i = 0; i < players.size(); i++) {
			System.out.println("Player " + players.get(i).getName()
					+ ", which dice do you want to use? (Enter numbers given for dice types)");
			System.out.println("If you do not wish to have specific dice, you can skip");
			String choice = sc.nextLine();
			try {
				int ch = Integer.parseInt(choice);
				if (ch > 0 && ch <= diceTypes.size()) {
					players.get(i).setDice(diceTypes.get(ch - 1).getDiceType());
					System.out.println(
							"Player " + players.get(i).getName() + " has choosen " + diceTypes.get(ch - 1).toString());
				} else {
					System.out.println("Player " + players.get(i).getName() + " has choosen default dice");
				}
			} catch (NumberFormatException e) {
				System.out.println("Player " + players.get(i).getName() + " has choosen default dice");
			}
		}

		GameService gameService = new GameServiceImpl(GAME_BOARD_SIZE);
		gameService.setPlayerOnBoard(players);
		gameService.setSnakesOnBoard(snakes, snakesPositions);
		System.out.println("Starting the game in 2 seconds...");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		};
		gameService.startGame();

		sc.close();
	}
}
