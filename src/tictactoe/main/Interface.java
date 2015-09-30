package tictactoe.main;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Interface extends JFrame implements ActionListener{
	
	JPanel panel;
	JButton[] button;
	int count = 0;
	int sign = 0;
	public Interface(){
		panel = new JPanel();
		panel.setLayout(new GridLayout(3,3));
		this.add(panel);
		button = new JButton[9];
		for(int i = 0; i <= 8; i++){
			button[i] = new JButton();
			panel.add(button[i]);
			button[i].setEnabled(true);
			button[i].addActionListener(this);
		}
		this.pack();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void fillCell(Character symbol){
		button[0].setText(symbol.toString());
	}
	
	public void actionPerformed(ActionEvent e){

		
	}
	
}
