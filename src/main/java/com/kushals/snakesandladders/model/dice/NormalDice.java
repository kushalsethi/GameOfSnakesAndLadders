package com.kushals.snakesandladders.model.dice;

import java.util.Random;

public class NormalDice extends Dice{

	@Override
	public int roll() {
		return new Random().nextInt(DICE_NUMBER_RANGE) + 1;
	}

}
