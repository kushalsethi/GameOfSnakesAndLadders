package com.kushals.snakesandladders.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameBoard {
	private int size;
	private List<Snake> snakes;
	private Map<String, Integer> playersPosition;
	
	public GameBoard(int size) {
		this.size = size;
		this.snakes = new ArrayList<>();
		this.playersPosition = new HashMap<>();
	}

	public List<Snake> getSnakes() {
		return snakes;
	}

	public void setSnakes(List<Snake> snakes) {
		this.snakes = snakes;
	}

	public Map<String, Integer> getPlayersPosition() {
		return playersPosition;
	}

	public void setPlayerPosition(Map<String, Integer> playersPosition) {
		this.playersPosition = playersPosition;
	}

	public int getSize() {
		return size;
	}
	
}
