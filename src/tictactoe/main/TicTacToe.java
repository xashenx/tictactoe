package tictactoe.main;

public class TicTacToe {

	public Board board;
	private Integer currentPlayer;
	private Integer gameState = 0;
	private Integer moves;
	private static final Integer MAX_MOVES = 9;
	private static Character[] symbols;
	private static final boolean DEBUG = false;

	public TicTacToe() {
		board = new Board();
		currentPlayer = 0;
		gameState = 1;
		moves = 0;
		symbols = new Character[2];
		symbols[0] = 'X';
		symbols[1] = 'O';
	}

	public Boolean isGameOver() {
		if (gameState > 1)
			return true;
		return false;
	}

	public Integer getGameState() {
		return gameState;
	}

	public Boolean move(Integer x, Integer y) {
		if (DEBUG) {
			System.out.println(x + " " + y);
			System.out.println(this.getGameState());
			System.out.println("moves: " + (this.getMoves() + 1));
		}
		if (board.validateMove(x, y, symbols[currentPlayer])) {
			if (DEBUG) {
				System.out.println("VALID MOVE(" + x + "," + y + ")");
			}
			if (++moves > 4)
				gameState = checkEndConditions(x, y);
			if (!this.isGameOver())
				currentPlayer = (currentPlayer + 1) % 2;
			return true;
		}
		if (DEBUG) {
			System.out.println("INVALID MOVE(" + x + "," + y + ")");
		}
		return false;
	}

	public Integer getCurrentPlayer() {
		return currentPlayer;
	}

	private Integer checkEndConditions(Integer x, Integer y) {
		if (board.cellContent(x, 0).equals(board.cellContent(x, 1))
				&& board.cellContent(x, 0).equals(board.cellContent(x, 2)))
			return 2; // vertical win

		if (board.cellContent(0, y).equals(board.cellContent(1, y))
				&& board.cellContent(0, y).equals(board.cellContent(2, y)))
			return 3; // horizontal win

		if (x * y != 6 || x * y != 2) {
			if ((board.cellContent(0, 0).equals(board.cellContent(1, 1))
					&& board.cellContent(0, 0).equals(board.cellContent(2, 2)))
					|| (board.cellContent(0, 2).equals(board.cellContent(1, 1))
							&& board.cellContent(0, 2).equals(board.cellContent(2, 0))))
				return 4; // diagonal win
		}

		if (moves == MAX_MOVES)
			return 5; // draw
		return 1;
	}

	public Integer getMoves() {
		return this.moves;
	}
}
