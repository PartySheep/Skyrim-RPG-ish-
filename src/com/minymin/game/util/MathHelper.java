package com.minymin.game.util;

public class MathHelper {

	public static float round(float number, int decimalPlaces) {
		int mult = 1;
		for (int i = 0; i < decimalPlaces; i++) {
			mult*=10;
		}
		return (float)Math.round(number*mult)/mult;
	}
	
}
