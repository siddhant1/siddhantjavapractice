package com.siddhant.game;

import java.util.Random;

public class RandomNumberGenerator {
public int range;
Random r;
public RandomNumberGenerator(int range ) {
	r= new Random();
	this.range= range;
}
public int generate() {
	return r.nextInt(range);
}

	
	
	
}
