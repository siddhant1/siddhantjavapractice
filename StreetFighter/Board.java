

import java.awt.Color;
import java.awt.Font;
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
	public boolean showInstruction;
public Board() {
	showInstruction = true;
	this.setFocusable(true);
	player =  new Player();
	enemy = new Enemy();
	loadBackground();
	setSize(GAME_HEIGHT, GAME_WIDTH);
	GameLoop();

}

public void GameOver(Graphics g) {
	if(isGameOver()) {
		g.setColor(Color.CYAN);
		g.setFont(new Font("Arial", Font.BOLD, 45));
		g.drawString("GAME OVERR!!!", 350, 300);
		timer.stop();
	}
}

public boolean isGameOver() {
	if(enemy.health<=0) {
		return true;
	}
	if(player.health<=0) {
		return true;
	}
	else return false;
}

public void GameLoop() {
	timer = new Timer(GAME_DELAY,(e)-> {
		repaint();
		player.fall();
		enemy.fall();
		Collision();
		isGameOver();
		if(!isGameOver()) {
			bindEvents();
			}		
//		checkCollision();
	});
	timer.start();	
} 
public void loadBackground() {
	background = new ImageIcon(Board.class.getResource("bg.gif")).getImage();
}

public void instruction(Graphics g) {
	g.setFont(new Font("Arial", Font.CENTER_BASELINE, 25));
	g.setColor(Color.GREEN);
	g.drawString("The Game Ends if Health Of any Player Reaches 0 , Press Control to remove Instructions" , 13, 50);
	g.drawString("Player1 : PRESS T TO PUNCH AND Y TO KICK, A,D   TO MOVE AND SPACE TO JUMP", 13, 100);
	g.drawString("Player2 : PRESS P TO PUNCH AND O TO KICK AND ARROW KEYS TO MOVE AND JUMP", 13, 150);
	
}

public void Collision() {
	 enemyRec = new Rectangle(enemy.x, enemy.y, enemy.w, enemy.h);
	playerRec = new Rectangle(player.x, player.y, player.w, player.h); 
}

public void checkCollision(Graphics g) {
	if(enemyRec.intersects(playerRec)&&enemy.State==KICK && !player.isKicked) {
		player.isKicked = true;
		player.setState(PUNCHED);
		player.health -= 20;
		
	}
	if(enemyRec.intersects(playerRec)&&enemy.State==PUNCH && !player.isPunched) {
		player.isPunched = true;
		player.setState(PUNCHED);
		player.health -= 10;
		
	}
}
public void checkCollision1(Graphics g) {
	if(enemyRec.intersects(playerRec)&&player.State==PUNCH && !enemy.isPunched) {
		enemy.setState(PUNCHED);
		enemy.isPunched=true;
		enemy.health -= 10;
	}
	if(enemyRec.intersects(playerRec)&&(player.State==KICK && !enemy.isKicked)){
		enemy.setState(PUNCHED);
		enemy.isKicked = true;
		enemy.health -= 20;
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
			if(e.getKeyCode()==KeyEvent.VK_CONTROL) {
				showInstruction = false;
			}
			
		}
	});
}

public void drawbackground(Graphics g) {
	g.drawImage(background, 0, 0, GAME_WIDTH, GAME_HEIGHT, null);
}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
//		enemy.DrawScore(g);

		drawbackground(g);
		if(showInstruction) {
			instruction(g);
		}
		GameOver(g);
		player.DrawOnState(g);
		checkCollision(g);
		checkCollision1(g);
		enemy.DrawOnState(g);
		player.move();
		enemy.move();

}
}
