

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements GameConstants,GameStates{
	public Image background;
	Timer timer;
	Player player ;
	Enemy enemy;
	Rectangle enemyRec;
	Rectangle playerRec;
public Board() {
	this.setFocusable(true);
	player =  new Player();
	enemy = new Enemy();
	loadBackground();
	setSize(GAME_HEIGHT, GAME_WIDTH);
	GameLoop();
	bindEvents();
}

public void GameLoop() {
	timer = new Timer(GAME_DELAY,(e)-> {
		repaint();
		player.fall();
		enemy.fall();
		Collision();
//		checkCollision();
	});
	timer.start();	
} 
public void loadBackground() {
	background = new ImageIcon(Board.class.getResource("bg.gif")).getImage();
}

public void Collision() {
	 enemyRec = new Rectangle(enemy.x, enemy.y, enemy.w, enemy.h);
	playerRec = new Rectangle(player.x, player.y, player.w, player.h); 
}

public void checkCollision(Graphics g) {
	if(enemyRec.intersects(playerRec)&&(enemy.State==KICK||enemy.State==PUNCH)) {
		player.punchEffectOnPlayer(g);
	}
}
public void checkCollision1(Graphics g) {
	if(enemyRec.intersects(playerRec)&&(player.State==KICK||player.State==PUNCH)) {
		enemy.punchEffectOnPlayer(g);
	}
}


public void bindEvents() {
	this.addKeyListener(new KeyListener() {
		
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void keyReleased(KeyEvent e) {
			
			player.stop();
			enemy.stop();
			
		}
		
		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode()==KeyEvent.VK_D) {
				player.moveLeft();
			}
			if(e.getKeyCode()==KeyEvent.VK_A) {
				player.moveRight();
			}
			if(e.getKeyCode()==KeyEvent.VK_SPACE) {
				player.setState(JUMP);
				player.jump();
			}
			if(e.getKeyCode()==KeyEvent.VK_T) {
				player.setState(PUNCH);
			}
			if(e.getKeyCode()==KeyEvent.VK_Y) {
				player.setState(KICK);
			}
			if(e.getKeyCode()==KeyEvent.VK_LEFT) {
				enemy.moveLeft();
			}
			if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
				enemy.moveRight();
			}
			if(e.getKeyCode()==KeyEvent.VK_UP) {
				enemy.setState(JUMP);
				enemy.jump();
			}
			if(e.getKeyCode()==KeyEvent.VK_P) {
				enemy.setState(PUNCH);
			}
			if(e.getKeyCode()==KeyEvent.VK_O) {
				enemy.setState(KICK);
			}
			
		}
	});
}

public void drawbackground(Graphics g) {
	g.drawImage(background, 0, 0, GAME_WIDTH, GAME_HEIGHT, null);
}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawbackground(g);
		player.DrawOnState(g);
		checkCollision(g);
		checkCollision1(g);
		enemy.DrawOnState(g);
		player.move();
		enemy.move();

}
}
