package com.kushals.snakesandladders.service;

import java.util.List;
import java.util.Map;

import com.kushals.snakesandladders.model.Player;
import com.kushals.snakesandladders.model.Snake;

public interface GameService {
	
	public void setPlayerOnBoard(List<Player> players);
	
	public void setSnakesOnBoard(List<Snake> snakes, Map<Integer, Snake> snakesPositions);
	
	public void startGame();
}
