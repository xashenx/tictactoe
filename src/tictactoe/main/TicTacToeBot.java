package tictactoe.main;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToeBot {
	private static final String DRAW_MESSAGE = "GAME ENDS WITH A DRAW!";
	private static final String START_MESSAGE = "GAME STARTED!\n";
	private static final String VALID_MOVE_MESSAGE = "MOVE #";
	private static final String INVALID_MOVE_MESSAGE = "INVALID MOVE! (";
	private static final String[] WIN_MESSAGE = { "PLAYER X WON!", "PLAYER O WON!" };
	private static Interface ui;
	// private static final String O_WON = "PLAYER O WON!";

	public static void main(String[] args) {
		TicTacToe game = new TicTacToe();
		System.out.println(START_MESSAGE);
		while (!game.isGameOver()) {
			int x = ThreadLocalRandom.current().nextInt(0, 3);
			int y = ThreadLocalRandom.current().nextInt(0, 3);
			if (game.move(x, y)) {
				try {
					System.out.println(VALID_MOVE_MESSAGE + game.getMoves() + " (" + x + "," + y + ")");
					game.board.printBoard();
					Thread.sleep(600);
				} catch (InterruptedException ex) {
					Thread.currentThread().interrupt();
				}
			} else
				System.out.println(INVALID_MOVE_MESSAGE + x + "," + y + ")");
		}
		
		ui = new Interface();
		
		if (game.getGameState() == 5)
			System.out.println(DRAW_MESSAGE);
		else
			System.out.println(WIN_MESSAGE[game.getCurrentPlayer()]);
	}
}
