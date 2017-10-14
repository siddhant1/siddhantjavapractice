package com.siddhant.game;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Player extends Sprite implements GameConstants {
	ArrayList<Bullet> bullets = new ArrayList<>();

	public Player() {
		isVisible = true;
		x=GAME_WIDTH/2-w/2;
		y= GAME_HEIGHT-150;
		xSPEED = ySPEED= 0;
//		ySPEED=10;
		w=h=100;
		life =3;
		img = new ImageIcon(Player.class.getResource("rocket.gif")).getImage();		
	}
	
	public void PrepareBullet() {
		Bullet bullet = new Bullet(x+42,y,-10);
		bullets.add(bullet);
	}
	
	public void drawBullet(Graphics g) {
		for(Bullet bullet : bullets) {
			bullet.drawBullet(g,PLAYER);	
			bullet.move();
		}
	}
	
	
	
//	public void checkCollision() {
//		if(x<0) {
//			SPEED =0;		}
//	}

	
	
	public void  PlayerImage() {
      
	}
	public void DrawPlayer(Graphics g ) {
		g.drawImage(img, x, y, w, h , null);
	}
	public void up() {
		
		ySPEED = -SPEED;
		
	}
	public void down() {
	   ySPEED = SPEED;
	}
	public void left() {
		
		xSPEED = -SPEED;
	}
	public void right() {
		
		xSPEED = SPEED;
	}
	public void move() {
	
	     x += xSPEED ; 
	     y += ySPEED ;
	}
	public void stop() {
		xSPEED = ySPEED =0;
	}
	
	
	
	
	
	
	
	
	
	
	

}
