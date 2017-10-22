

import javax.swing.JFrame;

public class Frame extends JFrame implements GameConstants {
	public Frame() {
		
		setSize(GAME_WIDTH, GAME_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle(GAME_TITLE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Board board = new Board();
		setVisible(true);
		add(board);
	}

	public static void main(String[] args) {
	Frame frame =  new Frame() ;

	}

}
