package com.siddhant.game;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.ImageIcon;

     
public class Enemy   extends Sprite implements GameConstants {
//static public int  Direction;
//static public int  y;
	int Direction =0;
 int ySPEED;
int counter;
//Timer timer ;
ArrayList<Bullet>bullets = new ArrayList<>();
     
     public  void prepareEnemyBullets() {
    	Bullet  bullet = new Bullet(x+30,y+30,15);
    	bullets.add(bullet);
     }
     public void DrawEnemyBullet(Graphics g) {
    	 for(Bullet bullet : bullets) {
    		 if(bullet.isVisible)
    		 bullet.drawBullet(g, ENEMY);
    	 }
     }



	public Enemy(int x) {
//    Direction =1;
    life =3;
    y=70;   
	w=70;
	h=65;
	this.x =x;
    ySPEED =10;
    isVisible = true;
    life =3;
    counter =0;
	 img = new ImageIcon(Enemy.class.getResource("alien2.gif")).getImage();	
	}
	public void DrawEnemy(Graphics g ) {
		g.drawImage(img, this.x, y, w, h , null);
 	}
	

	
}	

