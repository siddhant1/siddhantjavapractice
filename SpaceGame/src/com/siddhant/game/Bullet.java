package com.siddhant.game;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet extends Sprite implements GameConstants {

	public Bullet(int x,int y,int ySPEED) {
			
	     	 this.x =x;
		     this.y = y;
             this.ySPEED = ySPEED;

//				 ySPEED = -10;
				}
				public void move() {
					y += ySPEED;
				}
	
 

	public void drawBullet(Graphics g , int OWNER) {
		if(OWNER == PLAYER){
		g.setColor(Color.BLUE);}
		if(OWNER == ENEMY) {
			g.setColor(Color.YELLOW);
		}
		g.fillOval( x,y, 10, 10);
		move();
//		System.out.println("Coming here bruh");
	}
	
}	