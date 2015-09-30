package tictactoe.main;

public class Board {
	private Character[][] board;

	public Board() {
		// initialize the board array
		board = new Character[3][3];
		for (int row = 0; row < 3; row++)
			for (int col = 0; col < 3; col++)
				board[row][col] = (char) (' ');
	}

	public Boolean validateMove(Integer x, Integer y, Character currentPlayer) {
		if (board[x][y] == ' ') {
			doMove(x, y, currentPlayer);
			return true;
		} else
			return false;
	}

	public Character cellContent(Integer x, Integer y) {
		return board[x][y];
	}

	private void doMove(Integer x, Integer y, Character currentPlayer) {
		board[x][y] = currentPlayer;
	}

	public void printBoard() {
		System.out.println(board[0][0] + " | " + board[1][0] + " | " + board[2][0]);
		System.out.println("-" + " + " + "-" + " + " + "-");
		System.out.println(board[0][1] + " | " + board[1][1] + " | " + board[2][1]);
		System.out.println("-" + " + " + "-" + " + " + "-");
		System.out.println(board[0][2] + " | " + board[1][2] + " | " + board[2][2] + "\n");
	}
}
