package com.siddhant.game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements GameConstants{
private static final boolean Bullet = false;
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
int enemyCounter ;
public boolean isgoingupward;
//Enemy enemy;
private int x;
int c;
public boolean stop = true;
Enemy enemies[] = new Enemy[4];
public Board() {
	c=4;
	enemyCounter =3;
	r = new RandomNumberGenerator(4);
	x=60;

	setFocusable(true);
	player = new Player();
	removeBullet();
    checkCollision();
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

public void removeBullet() {
//	for(int i=0;i<enemies.length;i++) {
//	for(Bullet bullet : enemies[i].bullets)
//		if(bullet.x>GAME_WIDTH) {
//			enemies[i].bullets.remove(bullet);
//		}
//}
}


public void prepareEnemies() {
	for (int i=0;i<enemies.length;i++) {
		enemies[i] = new Enemy(x);
		x+=140;
		if(counter ==3) {
		enemies[i].prepareEnemyBullets();
		}
}}
public void GameLoop() {
	timer = new Timer(50,(e)-> {
		repaint();
		bindEvents();
		player.move();
	     checkCollision();
//		checkPlayerCollsion();
        counter++;

        if(counter ==35) {
        	counter =0;
        enemyCalling();
//        System.out.println(counter);
 
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

public void checkCollision() {

//for(int j=0;j<1;j++) {
	outerloop:
	for(int i=0;i<enemies.length;i++) {
		for(Bullet bullet : player.bullets) {
		 {
			if(enemies[i].isVisible) {
			if(isCollided(enemies[i] , bullet)){
               enemies[i].life--;
               System.out.println(enemies[i].life);
				 if(enemies[i].life==0) {
					 System.out.println("If");
				     enemies[i].isVisible = false;                         
				     }                                                       
				 else {
					 System.out.println("breaker");
		             break outerloop; 
				 }
			}
		}
	}
}
}
}

public void checkPlayerCollsion() {
for(int i=0;i<enemies.length;i++) {
	for(Bullet bullet : enemies[i].bullets) {
	
		if(player.isVisible && bullet.isVisible) {
		if(isPlayerShot(player, bullet)) {
			c--;
			System.out.println(c);
			if(c==0) {
				System.out.println(c);
			System.out.println("I am here");
			player.isVisible = false;
			bullet.isVisible = false;
			}
			else {
				break;
			}
		}
		}
		}
	}
}

public boolean isPlayerShot(Player player , Bullet bullet) {
int 	xDistance1 =  Math.abs(player.x-bullet.x);
int     yDistance1 = Math.abs(player.y-bullet.y);
//System.out.println(xDistance1);
//System.out.println(yDistance1);
//System.out.println(player.y);
//System.out.println(bullet.y);
//System.out.println(player.x);
//System.out.println(bullet.x);
//System.out.println(xDistance1<player.h && yDistance1<player.w);
return xDistance1<=player.w & yDistance1<=player.h;
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

public boolean isCollided(Enemy enemy,Bullet bullet) {
	int xDistance = Math.abs(enemy.x-bullet.x);
	int yDistance = Math.abs(enemy.y-bullet.y);
	return xDistance<=enemy.w && yDistance <= enemy.h;
			}
@Override
public void paintComponent(Graphics g) {
	super.paintComponent(g);
	DrawBackground(g);
	if(player.isVisible) {
	player.DrawPlayer(g);
	player.drawBullet(g);
	}
//	checkCollision();   
	
	for(Enemy enemy : enemies) {
     if(enemy.isVisible) {
	enemy.DrawEnemy(g);
	
	enemy.DrawEnemyBullet(g);


	}
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
