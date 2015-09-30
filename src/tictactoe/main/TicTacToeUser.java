package tictactoe.main;

public class TicTacToeUser {
	
		private static final String DRAW_MESSAGE = "GAME ENDS WITH A DRAW!";
		private static final String START_MESSAGE = "GAME STARTED!\n";
		private static final String VALID_MOVE_MESSAGE = "MOVE #";
		private static final String INVALID_MOVE_MESSAGE = "INVALID MOVE! (";
		private static final String[] WIN_MESSAGE = { "PLAYER X WON!", "PLAYER O WON!" };

		// private static final String O_WON = "PLAYER O WON!";

		public static void main(String[] args) {
			TicTacToe game = new TicTacToe(1); //usermode

		}
}
