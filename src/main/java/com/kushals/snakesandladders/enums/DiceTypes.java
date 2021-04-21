package com.kushals.snakesandladders.enums;

import com.kushals.snakesandladders.model.dice.AddThreeDice;
import com.kushals.snakesandladders.model.dice.CrookedDice;
import com.kushals.snakesandladders.model.dice.Dice;
import com.kushals.snakesandladders.model.dice.NormalDice;

public enum DiceTypes {
	NORMAL(new NormalDice()), CROOKED(new CrookedDice()), ADD_THREE(new AddThreeDice());
	
	private Dice dice;
	
	private DiceTypes(Dice dice) {
		this.dice = dice;
	}
	
	public Dice getDiceType() {
		return dice;
	}
}
