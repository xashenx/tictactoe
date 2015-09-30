package tictactoe.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import tictactoe.main.TicTacToe;

public class TicTacToeBoardTest {
	private TicTacToe game;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		game = new TicTacToe();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void boardCreated() {
		//TDD stage 1
		for (int row = 0; row < 3; row++)
			for (int col = 0; col < 3; col++)
				assertEquals((Character)' ', game.board.cellContent(row, col));
	}

}
