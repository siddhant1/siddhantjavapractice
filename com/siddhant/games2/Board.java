package com.siddhant.games2;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.Timer;

import com.siddhant.games2.utils.GameConstants;

public class Board extends JPanel implements GameConstants{
	Timer timer;
	Balls ball[] = new Balls[MAX_BALLS];
public Board() {
	
	setSize(GAME_HEIGHT, GAME_WIDTH);
	setBackground(Color.BLACK);
	prepareBalls();
	GameLoop();
}

public void prepareBalls() {
	for (int i=0;i<MAX_BALLS;i++) {
		ball[i] = new Balls();
	}
}

public void GameLoop() {
	timer = new Timer(GAME_DELAY,(e)-> {
		repaint();
		checkCollision();
	});
	timer.start();	
} 

public void checkCollision() {
	
	System.out.println("Entered");
	for(int i=0;i<ball.length-1;i++) {
		for(int j=i+1;j<ball.length;j++) {
			System.out.println("In the loop");
//ball[i].setVisible(true);
//ball[j].setVisible(true);
			if(ball[i].isVisible() && ball[j].isVisible()) {
				System.out.println("Checking condition");
			if(isCollision(ball[i],ball[j])) {
				ball[i].setVisible(false);
				System.out.println("COndition checked");
				ball[j].setVisible(false);
			}
		}
	}
	
}
}

 public boolean isCollision(Balls Firstball , Balls Secondball) {
	 
			 int xDistance = Math.abs(Firstball.getX()-Secondball.getX());
			 int yDistance = Math.abs(Firstball.getY()-Secondball.getY());
			 return xDistance<=Firstball.getW() && yDistance<=Firstball.getH();
		 }
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
        for (int i=0;i<ball.length;i++) {
        	if(ball[i].isVisible()) {
        	ball[i].DrawBall(g);
        	ball[i].move();
        	ball[i].changeDirection();
        }
	}
}
}

