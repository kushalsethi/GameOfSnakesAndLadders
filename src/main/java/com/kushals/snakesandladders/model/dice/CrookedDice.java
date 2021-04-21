package com.kushals.snakesandladders.model.dice;

import java.util.Random;

public class CrookedDice extends Dice{

	@Override
	public int roll() {
		return (new Random().nextInt(3) + 1) * 2;
	}

}
