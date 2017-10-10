package com.siddhant.games2;

import java.awt.Color;
import java.awt.Graphics;

import com.siddhant.games2.utils.GameConstants;
import com.siddhant.games2.utils.RandomNo;

public class Balls implements GameConstants {
	
	static RandomNo r ;
	private int xSPEED=r.getRandomNO();
	private int ySPEED=r.getRandomNO();
	private int w = 50;
	private int h = 50;
	private int x = r.getRandomNO();
	private int y = r.getRandomNO();
    private boolean isVisible;
	public Balls() {
		isVisible =  true;
	}
	public boolean isVisible() {
		return isVisible;
	}

	static {
		r = new RandomNo(50);
				
	}
	public void DrawBall(Graphics g) {
		g.setColor(Color.RED);
		g.fillOval(x, y, w, h);
		
	}
	
	
	
public static RandomNo getR() {
		return r;
	}



	public static void setR(RandomNo r) {
		Balls.r = r;
	}



	public void  setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}



	public int getxSPEED() {
		return xSPEED;
	}



	public void setxSPEED(int xSPEED) {
		this.xSPEED = xSPEED;
	}



	public int getySPEED() {
		return ySPEED;
	}



	public void setySPEED(int ySPEED) {
		this.ySPEED = ySPEED;
	}



	public int getW() {
		return w;
	}



	public void setW(int w) {
		this.w = w;
	}



	public int getH() {
		return h;
	}



	public void setH(int h) {
		this.h = h;
	}



	public int getX() {
		return x;
	}



	public void setX(int x) {
		this.x = x;
	}



	public int getY() {
		return y;
	}



	public void setY(int y) {
		this.y = y;
	}



public void move() {
	 x += xSPEED;
	 y+= ySPEED;
}
public void changeDirection() 
{
	if(x>GAME_HEIGHT-50) {
		xSPEED = -r.getRandomNO();
		
	}
	if(x<0) {
		xSPEED = r.getRandomNO();
	}
	if(y>GAME_WIDTH-50) {
		ySPEED = -r.getRandomNO();
	}
if(y<0) {
	ySPEED = r.getRandomNO();
}
}
}
	