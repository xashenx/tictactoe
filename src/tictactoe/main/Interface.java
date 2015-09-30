package tictactoe.main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Interface extends JFrame implements ActionListener {

	JPanel panel, panel2;
	JButton[] button;
	JLabel label;
	int count = 0;
	int sign = 0;
	private TicTacToe game;
	
    private JMenuBar barraMenu;
    private JMenu menu;
    private JMenuItem restart;

	public Interface(TicTacToe ttt) {
		game = ttt;
		
		
	    
	    //Barra menu y opciones menu
	    barraMenu = new JMenuBar();
	    menu = new JMenu("Menu");
	    restart = new JMenuItem("Restart");
	    barraMenu.add(menu);
	    menu.add(restart);
	    setJMenuBar(barraMenu);
		
		this.setSize(500,500);
		panel = new JPanel();
		panel.setLayout(new GridLayout(3, 3));
		this.getContentPane().setLayout(new BorderLayout());
		label = new JLabel("", SwingConstants.CENTER);
		//this.add(panel);
		this.getContentPane().add(label,BorderLayout.SOUTH);
		this.getContentPane().add(panel,BorderLayout.CENTER);
		button = new JButton[9];
		for (int i = 0; i <= 8; i++) {
			button[i] = new JButton();
			button[i].setFont(new Font("Arial", Font.PLAIN, 40));
			panel.add(button[i]);
			button[i].setEnabled(true);
			button[i].addActionListener(this);
		}
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public void fillCell(Integer x, Integer y, String symbol) {
		if (x == 0 && y == 0)
			button[6].setText(symbol);
		else if (x == 0 && y == 1)
			button[3].setText(symbol);
		else if (x == 0 && y == 2)
			button[0].setText(symbol);
		else if (x == 1 && y == 0)
			button[7].setText(symbol);
		else if (x == 1 && y == 1)
			button[4].setText(symbol);
		else if (x == 1 && y == 2)
			button[1].setText(symbol);
		else if (x == 2 && y == 0)
			button[8].setText(symbol);
		else if (x == 2 && y == 1)
			button[5].setText(symbol);
		else if (x == 2 && y == 2)
			button[2].setText(symbol);
	}

	
	public void setLabel(String message){
		label.setText(message);
	}
	public void actionPerformed(ActionEvent e) {
		for(int i=0;i<9;i++)
			if(button[i] == e.getSource()){
				if(game.isGameOver())
					label.setText("The game is OVER!");
				else if(button[i].getText() == "")
					doMove(i);
				else
					label.setText("That cell is occupied!");
			}
	}
	
	private void doMove(Integer i){
		if (i == 6)
			game.move(0, 0);
		else if (i == 3)
			game.move(0, 1);
		else if (i == 0)
			game.move(0, 2);
		else if (i == 7)
			game.move(1, 0);
		else if (i == 4)
			game.move(1, 1);
		else if (i == 1)
			game.move(1, 2);
		else if (i == 8)
			game.move(2, 0);
		else if (i == 5)
			game.move(2, 1);
		else if(i == 2)
			game.move(2, 2);
	}

}
