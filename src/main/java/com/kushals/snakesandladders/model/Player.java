package com.kushals.snakesandladders.model;

import java.util.UUID;

public class Player {
	String name;
	String id;
	int diceType;
	
	public Player(String name) {
		this.name = name;
		this.id = UUID.randomUUID().toString();
		this.diceType = 1; // normal dice
	}
	
	public Player(String name, int diceType) {
		this.name = name;
		this.id = UUID.randomUUID().toString();
		this.diceType = diceType;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public int getDiceType() {
		return diceType;
	}

	public void setDiceType(int diceType) {
		this.diceType = diceType;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", id=" + id + "]";
	}
	
}
