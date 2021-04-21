package com.kushals.snakesandladders.starter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.kushals.snakesandladders.model.Player;
import com.kushals.snakesandladders.model.Snake;
import com.kushals.snakesandladders.service.GameService;
import com.kushals.snakesandladders.service.GameServiceImpl;

public class GameStarterTest {
	
	private static int GAME_BOARD_SIZE = 100;
	
	@Test
	public void testSinglePlayerGame() {
		
		int numOfSnakes = 1;
		List<Snake> snakes = new ArrayList<>();
		Map<Integer, Snake> snakesPositions = new HashMap<>();
		for(int i = 0; i < numOfSnakes; i++) {
			int start = 14;
			int end = 7;
			Snake snake = new Snake(start, end);
			snakes.add(snake);
			snakesPositions.put(start, snake);
		}
		
		int numOfPlayer = 1;
		List<Player> players = new ArrayList<>();
		for(int i = 1; i <= numOfPlayer; i++) {
			players.add(new Player("Test Player" + i));
		}
		
		int diceType = 1; // Normal dice
		GameService gameService = new GameServiceImpl(GAME_BOARD_SIZE, diceType);
		gameService.setPlayerOnBoard(players);
		gameService.setSnakesOnBoard(snakes, snakesPositions);
		
		gameService.startGame();
	}
	
	@Test
	public void testSinglePlayerGameWithCrookedDice() {
		
		int numOfSnakes = 1;
		List<Snake> snakes = new ArrayList<>();
		Map<Integer, Snake> snakesPositions = new HashMap<>();
		for(int i = 0; i < numOfSnakes; i++) {
			int start = 14;
			int end = 7;
			Snake snake = new Snake(start, end);
			snakes.add(snake);
			snakesPositions.put(start, snake);
		}
		
		int numOfPlayer = 1;
		List<Player> players = new ArrayList<>();
		for(int i = 1; i <= numOfPlayer; i++) {
			players.add(new Player("Test Player"));
		}
		
		int diceType = 2; // Crooked dice
		GameService gameService = new GameServiceImpl(GAME_BOARD_SIZE, diceType);
		gameService.setPlayerOnBoard(players);
		gameService.setSnakesOnBoard(snakes, snakesPositions);
		
		gameService.startGame();
	}
	
}
