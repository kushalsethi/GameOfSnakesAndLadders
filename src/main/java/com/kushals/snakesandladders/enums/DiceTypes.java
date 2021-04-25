package com.kushals.snakesandladders.enums;

import com.kushals.snakesandladders.model.dice.AddThreeDice;
import com.kushals.snakesandladders.model.dice.CrookedDice;
import com.kushals.snakesandladders.model.dice.Dice;
import com.kushals.snakesandladders.model.dice.NormalDice;

public enum DiceTypes {
	NORMAL("1. Normal ",new NormalDice()), CROOKED("2. Crooked ", new CrookedDice()), ADD_THREE("3. Add Three ", new AddThreeDice());
	
	private Dice dice;
	private String type;
	private DiceTypes(String type, Dice dice) {
		this.type = type;
		this.dice = dice;
	}
	
	public String getType() {
		return type;
	}
	
	public Dice getDiceType() {
		return dice;
	}
	
	public String toString() {
		return type;
	}
}
