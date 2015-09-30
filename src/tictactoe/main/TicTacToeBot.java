package tictactoe.main;

import java.util.concurrent.ThreadLocalRandom;

public class TicTacToeBot {
	private static final String DRAW_MESSAGE = "GAME ENDS WITH A DRAW!";
	private static final String START_MESSAGE = "GAME STARTED!\n";
	private static final String VALID_MOVE_MESSAGE = "MOVE #";
	private static final String INVALID_MOVE_MESSAGE = "INVALID MOVE! (";
	private static final String[] WIN_MESSAGE = { "PLAYER X WON!", "PLAYER O WON!" };

	// private static final String O_WON = "PLAYER O WON!";
	public void restart(){
		main(null);
	}

	public static void main(String[] args) {
		TicTacToe game = new TicTacToe(2); // bot mode
		System.out.println(START_MESSAGE);
		while (!game.isGameOver()) {
			int x = ThreadLocalRandom.current().nextInt(0, 3);
			int y = ThreadLocalRandom.current().nextInt(0, 3);
			if (game.move(x, y)) {
				try {
					System.out.println(VALID_MOVE_MESSAGE + game.getMoves() + " (" + x + "," + y + ")");
					game.board.printBoard();
					Thread.sleep(2000);
				} catch (InterruptedException ex) {
					Thread.currentThread().interrupt();
				}
			} else
				System.out.println(INVALID_MOVE_MESSAGE + x + "," + y + ")");
		}
		if (game.getGameState() == 5)
			System.out.println(DRAW_MESSAGE);
		else
			System.out.println(WIN_MESSAGE[game.getCurrentPlayer()]);
	}
}
