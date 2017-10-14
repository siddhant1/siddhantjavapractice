package com.siddhant.game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements GameConstants{
private Image backGroundImage;
Timer timer;
Player player ;
RandomNumberGenerator r;
static public boolean isStop; 
//static {
//	isStop = true;
//}
//public int  Moving =-1;
public int counter;
public boolean isgoingupward;
//Enemy enemy;
private int x;
Enemy enemies[] = new Enemy[4];
public Board() {
	r = new RandomNumberGenerator(4);
	x=60;
	setFocusable(true);
	player = new Player();
	prepareEnemies();
	DrawImage();
	GameLoop();

	
//	player.checkCollision();
}
public void MoveEnemies(){

	       /* if(!isStop && Enemy.MovingY == 70 ) {
	        System.out.println(Enemy.MovingY);	
	        System.out.println(counter);
		    System.out.println("First");
		    counter =0;
		    isStop = true ;
		    Moving =0;
	    }	
		else if( counter==5000 && Enemy.MovingY ==70  ) {
//			System.out.println(counter);
			System.out.println("2");
			System.out.println("I am going on");
			System.out.println(Enemy.MovingY);
        	counter =0;
			isStop=false;
			Moving =-1;
		}
		else if( Enemy.MovingY ==150 && !isStop  ){
			System.out.println(Enemy.MovingY);
			System.out.println("3");
			counter =0;
			isStop = true;
			Moving =0;
		}
		else if(counter == 5000 && Enemy.MovingY == 150) {
//			System.out.println(Enemy.MovingY);
//			System.out.println("4");
			counter =0;
//			System.out.println("Coming here too");
			isStop = false;
			Moving =1;
		}
//	       */
}




public void prepareEnemies() {
	for (int i=0;i<enemies.length;i++) {
		enemies[i] = new Enemy(x);
		x+=140;
//		if(counter ==3) {
//		enemies[i].prepareEnemyBullets();
//		}
}}
public void GameLoop() {
	timer = new Timer(50,(e)-> {
		repaint();
		bindEvents();
		player.move();
        counter++;
        if(counter ==10) {
        	counter =0;
        enemyCalling();
        }
		//MoveEnemies();
//		 counter += 50;
//		System.out.println(counter);
		
//		player.checkCollision();
//		player.isOutOfRange();
	});
	timer.start();
}
public void DrawBackground(Graphics g) {
	g.drawImage(backGroundImage, 0, 0,GAME_HEIGHT,GAME_WIDTH, null);
}

public void DrawImage() {
	backGroundImage = new ImageIcon(Board.class.getResource("space.jpg")).getImage();
}
public void bindEvents() {
	this.addKeyListener(new KeyAdapter() {
	
		@Override
		public void keyReleased(KeyEvent e)	 {
			player.stop();
			
		}
		
		
		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode()==KeyEvent.VK_SPACE) {
				player.PrepareBullet();

				
			}
			if(e.getKeyCode()==KeyEvent.VK_W) {
				player.up();
			}
			if(e.getKeyCode()==KeyEvent.VK_S) {
				player.down();
			}
			if(e.getKeyCode()==KeyEvent.VK_A) {
//				player.SPEED_OF_X =20;
				player.left();
			}
			if(e.getKeyCode()==KeyEvent.VK_D) {
//				player.SPEED_OF_X =20;
				player.right();
			}
//			player.move();
			
			
		}
	});
} 
public void enemyCalling() {
	int i = r.generate();
	
		enemies[i].prepareEnemyBullets();
	
}
@Override
public void paintComponent(Graphics g) {
	super.paintComponent(g);
	DrawBackground(g);
	player.DrawPlayer(g);
	player.drawBullet(g);
	for(Enemy enemy : enemies) {
	enemy.DrawEnemy(g);
	enemy.DrawEnemyBullet(g);
	
//	enemy.move();
	}
/*	
	if(!isStop &&Moving ==1) {
		
		Enemy.Direction--;
		
	for(Enemy enemy : enemies) {
	enemy.DrawEnemy(g);
	enemy.move();}
	}
	
	if(isStop&&Moving==0) {
//		System.out.println("I am coming here");
//		Enemy.MovingY=0;
		Enemy.Direction=0;
		
	for(Enemy enemy : enemies) {
	enemy.DrawEnemy(g);
	enemy.move();}
	}
	
	if(!isStop&&Moving ==-1) {
		Enemy.Direction++;
		
	for(Enemy enemy : enemies) {
	enemy.DrawEnemy(g);
	enemy.move();}
	}
//	player.isOutOfRange(g);
 */
 
}
}
