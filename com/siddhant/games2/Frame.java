package com.siddhant.games2;

import javax.swing.JFrame;

import com.siddhant.games2.utils.GameConstants;

public class Frame extends JFrame implements GameConstants {
	public Frame() {
		
		setSize(GAME_WIDTH, GAME_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle(GAME_TITLE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Board board = new Board();
		add(board);
		setVisible(true);
	}

	public static void main(String[] args) {
	Frame frame =  new Frame() ;

	}

}
