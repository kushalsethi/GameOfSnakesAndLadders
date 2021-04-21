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
		
		System.out.println("Enter number of players for the game");
		int numOfPlayer = sc.nextInt();
		List<Player> players = new ArrayList<>();
		for(int i = 1; i <= numOfPlayer; i++) {
			System.out.println("Enter name for the player "+ i);
			players.add(new Player(sc.next()));
		}
		
		System.out.println("Enter number of snakes for the game");
		int numOfSnakes = sc.nextInt();
		List<Snake> snakes = new ArrayList<>();
		Map<Integer, Snake> snakesPositions = new HashMap<>();
		for(int i = 0; i < numOfSnakes; i++) {
			System.out.println("Enter the start position for snake");
			int start = sc.nextInt();
			System.out.println("Enter the end position for snake (strictly less than start position)");
			int end = sc.nextInt();
			Snake snake = new Snake(start, end);
			snakes.add(snake);
			snakesPositions.put(start, snake);
		}
		
		System.out.println("Available Dice Types:");
		System.out.println(Arrays.asList(DiceTypes.values()));
		for(int i = 0; i < players.size(); i++) {
			System.out.println("Which dice do you want to use?");
			System.out.println("If you do not wish to have specific dice, you can skip");
			String choice = sc.nextLine();
			
			switch(choice) {
				case "1" : players.get(i).setDiceType(1);
					break;
				case "2" : players.get(i).setDiceType(2);
					break;
				default :
					System.out.println("Default dice has been choosen which is normal dice");
					players.get(i).setDiceType(1);
			}
		}
		
		GameService gameService = new GameServiceImpl(GAME_BOARD_SIZE);
		gameService.setPlayerOnBoard(players);
		gameService.setSnakesOnBoard(snakes, snakesPositions);
		
		gameService.startGame();
		
		sc.close();
	}
}
