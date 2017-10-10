package com.siddhant.games2.utils;

import java.util.Random;

public class RandomNo {
	Random r ;
	int range;
	public RandomNo(int range) {
		this.range =  range;
		r = new Random(this.range);
	}
	
	public int getRandomNO() {
		return r.nextInt(range);
	}

}
