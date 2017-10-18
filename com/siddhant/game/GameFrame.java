package com.siddhant.game;

import javax.swing.JFrame;

public class GameFrame extends JFrame implements GameConstants {

	public GameFrame() {
		Board  board = new Board();
		setSize(GAME_WIDTH, GAME_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle(GAME_TITLE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		add(board);
		
		
	}
	
	public static void main(String[] args) {
		GameFrame Frame = new GameFrame();

	}

}
