package com.kushals.snakesandladders.model;

import java.util.UUID;

import com.kushals.snakesandladders.enums.DiceTypes;
import com.kushals.snakesandladders.model.dice.Dice;

public class Player {
	String name;
	String id;
	Dice dice;
	
	public Player(String name) {
		this.name = name;
		this.id = UUID.randomUUID().toString();
		this.dice = DiceTypes.NORMAL.getDiceType(); // normal dice
	}
	
	public Player(String name, Dice dice) {
		this.name = name;
		this.id = UUID.randomUUID().toString();
		this.dice = dice;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public Dice getDice() {
		return dice;
	}

	public void setDice(Dice dice) {
		this.dice = dice;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", id=" + id + "]";
	}
	
}
