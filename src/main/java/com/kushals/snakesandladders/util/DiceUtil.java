package com.kushals.snakesandladders.util;

import java.util.Random;

public class DiceUtil {
	
	private static final int DICE_NUMBER_RANGE = 6; 
	
	public static int throwDice() {
		return new Random().nextInt(DICE_NUMBER_RANGE) + 1;
	}
	
	public static int throwCrookedDice() {
		return (new Random().nextInt(3) + 1) * 2;
	}
}
