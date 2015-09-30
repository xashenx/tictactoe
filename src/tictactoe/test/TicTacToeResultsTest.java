package tictactoe.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import tictactoe.main.TicTacToe;

public class TicTacToeResultsTest {
	private TicTacToe game;

	@Before
	public void setUp() throws Exception {
		game = new TicTacToe();
	}

	@After
	public void tearDown() throws Exception {
		game = null;
	}

	@Test
	public void verticalWin() {
		//TDD stage 2
		game.move(0, 0);
		assertEquals((Character)'X', game.board.cellContent(0,0));
		game.move(1, 1);
		assertEquals((Character)'O', game.board.cellContent(1,1));
		game.move(0, 1);
		assertEquals((Character)'X', game.board.cellContent(0,1));
		game.move(1, 2);
		assertEquals((Character)'O', game.board.cellContent(1,2));
		game.move(0, 2);
		assertEquals((Character)'X', game.board.cellContent(0,2));
		assertEquals(true,game.isGameOver());
		assertEquals((Integer)2,game.getGameState());
	}
	
	@Test
	public void horizontalWinR1() {
		//TDD stage 3
		game.move(0, 0);
		assertEquals((Character)'X', game.board.cellContent(0,0));
		game.move(1, 1);
		assertEquals((Character)'O', game.board.cellContent(1,1));
		game.move(1, 0);
		assertEquals((Character)'X', game.board.cellContent(1,0));
		game.move(1, 2);
		assertEquals((Character)'O', game.board.cellContent(1,2));
		game.move(2, 0);
		assertEquals((Character)'X', game.board.cellContent(2,0));
		assertEquals(true,game.isGameOver());
		assertEquals((Integer)3,game.getGameState());
	}
	
	@Test
	public void horizontalWinR2() {
		//TDD stage 3
		game.move(0, 1);
		assertEquals((Character)'X', game.board.cellContent(0,1));
		game.move(1, 2);
		assertEquals((Character)'O', game.board.cellContent(1,2));
		game.move(1, 1);
		assertEquals((Character)'X', game.board.cellContent(1,1));
		game.move(1, 0);
		assertEquals((Character)'O', game.board.cellContent(1,0));
		game.move(2, 1);
		assertEquals((Character)'X', game.board.cellContent(2,1));
		assertEquals(true,game.isGameOver());
		assertEquals((Integer)3,game.getGameState());
	}
	
	@Test
	public void horizontalWinR3() {
		//TDD stage 3
		game.move(0, 2);
		assertEquals((Character)'X', game.board.cellContent(0,2));
		game.move(1, 1);
		assertEquals((Character)'O', game.board.cellContent(1,1));
		game.move(1, 2);
		assertEquals((Character)'X', game.board.cellContent(1,2));
		game.move(1, 0);
		assertEquals((Character)'O', game.board.cellContent(1,0));
		game.move(2, 2);
		assertEquals((Character)'X', game.board.cellContent(2,2));
		assertEquals(true,game.isGameOver());
		assertEquals((Integer)3,game.getGameState());
	}
	
	@Test
	public void diagonalWin1(){
		//TDD stage 4
		game.move(0, 0);
		assertEquals((Character)'X', game.board.cellContent(0,0));
		game.move(1, 0);
		assertEquals((Character)'O', game.board.cellContent(1,0));
		game.move(1, 1);
		assertEquals((Character)'X', game.board.cellContent(1,1));
		game.move(0, 1);
		assertEquals((Character)'O', game.board.cellContent(0,1));
		game.move(2, 2);
		assertEquals((Character)'X', game.board.cellContent(2,2));
		assertEquals(true,game.isGameOver());
		assertEquals((Integer)4,game.getGameState());
	}
	
	public void diagonalWin2(){
		//TDD stage 4
		game.move(0, 2);
		assertEquals((Character)'X', game.board.cellContent(0,2));
		game.move(1, 0);
		assertEquals((Character)'O', game.board.cellContent(1,0));
		game.move(1, 1);
		assertEquals((Character)'X', game.board.cellContent(1,1));
		game.move(0, 1);
		assertEquals((Character)'O', game.board.cellContent(0,1));
		game.move(2, 0);
		assertEquals((Character)'X', game.board.cellContent(2,0));
		assertEquals(true,game.isGameOver());
		assertEquals((Integer)4,game.getGameState());
	}
	
	@Test
	public void draw(){
		//TDD stage 5
		game.move(0, 0);
		assertEquals((Character)'X', game.board.cellContent(0,0));
		game.move(2, 0);
		assertEquals((Character)'O', game.board.cellContent(2,0));
		game.move(1, 0);
		assertEquals((Character)'X', game.board.cellContent(1,0));
		game.move(0, 1);
		assertEquals((Character)'O', game.board.cellContent(0,1));
		game.move(2, 1);
		assertEquals((Character)'X', game.board.cellContent(2,1));
		game.move(1, 1);
		assertEquals((Character)'O', game.board.cellContent(1,1));
		game.move(0, 2);
		assertEquals((Character)'X', game.board.cellContent(0,2));
		game.move(1, 2);
		assertEquals((Character)'O', game.board.cellContent(1,2));
		game.move(2, 2);
		assertEquals((Character)'X', game.board.cellContent(2,2));
		assertEquals(true,game.isGameOver());
		assertEquals((Integer)5,game.getGameState());
	}
}
