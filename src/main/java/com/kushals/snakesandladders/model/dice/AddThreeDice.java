package com.kushals.snakesandladders.model.dice;

import java.util.Random;

public class AddThreeDice extends Dice {

	private static final int OFFSET = 3;

	@Override
	public int roll() {
		return ((new Random().nextInt(DICE_NUMBER_RANGE) + 1) + OFFSET) % DICE_NUMBER_RANGE;
	}

}
