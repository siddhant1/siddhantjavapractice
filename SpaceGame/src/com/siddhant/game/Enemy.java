package com.siddhant.game;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.ImageIcon;

     
public class Enemy   extends Sprite implements GameConstants {
//static public int  Direction;
//static public int  y;
 int ySPEED;

ArrayList<Bullet>bullets = new ArrayList<>();
     
     public  void prepareEnemyBullets() {
    	Bullet  bullet = new Bullet(x+30,y+30,10);
    	bullets.add(bullet);
     }
     public void DrawEnemyBullet(Graphics g) {
    	 for(Bullet bullet : bullets) {
    		 bullet.drawBullet(g, ENEMY);
    	 }
     }


	public Enemy(int x) {
//    Direction =1;
    y=70;   
	w=70;
	h=65;
	this.x =x;
    ySPEED =10;
	 img = new ImageIcon(Enemy.class.getResource("alien2.gif")).getImage();	
	}
	public void DrawEnemy(Graphics g ) {
		g.drawImage(img, this.x, y, w, h , null);
	}
//	public void move() {
//		MovingY +=Direction;
//	}

}
