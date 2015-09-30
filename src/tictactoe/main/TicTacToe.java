package tictactoe.main;

public class TicTacToe {

	public Board board;
	private Integer currentPlayer;
	private Integer gameState = 0;
	private Integer moves;
	private static final Integer MAX_MOVES = 9;
	private static Character[] symbols;
	private static final boolean DEBUG = false;
	private static Interface ui;
	private static final String DRAW_MESSAGE = "GAME ENDS WITH A DRAW!";
	private static final String[] WIN_MESSAGE = { "PLAYER X WON!", "PLAYER O WON!" };
	private Integer mode;

	public TicTacToe(Integer mode) {
		this.mode = mode; 
		board = new Board();
		currentPlayer = 0;
		gameState = 1;
		moves = 0;
		symbols = new Character[2];
		symbols[0] = 'X';
		symbols[1] = 'O';
		if(mode != 3){
				ui = new Interface(this);	
		}
	}

	public Boolean move(Integer x, Integer y) {
		// tries to perform the requested move
		if (DEBUG) {
			System.out.println(x + " " + y);
			System.out.println(this.getGameState());
			System.out.println("moves: " + (this.getMoves() + 1));
		}
		if (board.validateMove(x, y, symbols[currentPlayer])) {
			// checks if the move is valid
			if(mode != 3) // fills the cell on the interface
				ui.fillCell(x, y, getCurrentPlayerSymbol().toString());
			if (DEBUG) {
				System.out.println("VALID MOVE(" + x + "," + y + ")");
			}
			if (++moves > 4)
				// checks if the ending conditions are met
				gameState = checkEndConditions(x, y);
			if (!this.isGameOver())
				// give control to the next player if the game is not over
				currentPlayer = (currentPlayer + 1) % 2;
			else if (mode != 3){
				// if the game is over prints the end message on the ui
				if (getGameState() == 5)
					ui.setLabel(DRAW_MESSAGE);
				else
					ui.setLabel(WIN_MESSAGE[getCurrentPlayer()]);

			}
			return true;
		}
		if (DEBUG) {
			System.out.println("INVALID MOVE(" + x + "," + y + ")");
		}
		return false;
	}
	
	public Boolean isGameOver() {
		if (gameState > 1)
			return true;
		return false;
	}

	public Integer getGameState() {
		return gameState;
	}

	public Integer getCurrentPlayer() {
		return currentPlayer;
	}

	public Character getCurrentPlayerSymbol() {
		return symbols[currentPlayer];
	}

	private Integer checkEndConditions(Integer x, Integer y) {
		if (board.cellContent(x, 0).equals(board.cellContent(x, 1))
				&& board.cellContent(x, 0).equals(board.cellContent(x, 2)))
			return 2; // vertical win

		if (board.cellContent(0, y).equals(board.cellContent(1, y))
				&& board.cellContent(0, y).equals(board.cellContent(2, y)))
			return 3; // horizontal win

		if ((x * y != 6 || x * y != 2) && board.cellContent(1, 1).equals(board.cellContent(x, y))) 
			if ((board.cellContent(0, 0).equals(board.cellContent(1, 1))
					&& board.cellContent(0, 0).equals(board.cellContent(2, 2)))
					|| (board.cellContent(0, 2).equals(board.cellContent(1, 1))
							&& board.cellContent(0, 2).equals(board.cellContent(2, 0)))) {
				return 4; // diagonal win
		}

		if (moves == MAX_MOVES)
			return 5; // draw
		return 1;
	}

	public Integer getMoves() {
		return this.moves;
	}
	
	public Integer getMode(){
		return this.mode;
	}
}
