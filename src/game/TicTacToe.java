package game;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class TicTacToe {
	
	TicTacToeGame currentGame;
	GridBagConstraints constraints;
	
	JFrame frame;
	JButton[] buttons = new JButton[9];
	
	int delay;
	
	public void newGameReplay() {
		
		JDialog dialog = new JDialog();
		dialog.setLayout(new GridBagLayout());
		dialog.setTitle("Tic Tac Toe");
		dialog.setSize(300,  200);
		dialog.setLocationRelativeTo(null);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
		
		JButton newGameButton = new JButton("New Game");
		GridBagConstraints constraints;
		constraints = new GridBagConstraints();
		constraints.gridy = 0;
		constraints.gridx = 0;
		constraints.weighty = 1;
		constraints.fill = GridBagConstraints.CENTER;
		newGameButton.setSize(50, 50);
		newGameButton.setFocusable(false);
		newGameButton.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				start();
				dialog.dispose();
			}
		});
		dialog.add(newGameButton, constraints);
		
		
		JButton replayButton = new JButton("Replay");
		constraints = new GridBagConstraints();
		constraints.gridy = 1;
		constraints.gridx = 0;
		constraints.weighty = 1;
		constraints.fill = GridBagConstraints.CENTER;
		replayButton.setSize(50, 50);
		replayButton.setFocusable(false);
		replayButton.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				start();
				replay();
				dialog.dispose();
			}
		});
		dialog.add(replayButton, constraints);
		
	} 
	
	public void start() {

		frame = new JFrame("Tic Tac Toe");
		frame.setLayout(new GridBagLayout());
		
		 
		//Initializing and positioning nameX Field
		JTextField nameX = new JTextField("Player 1");
		constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.weightx = 1;
		frame.add(nameX, constraints);
		//X Label
		JLabel x = new JLabel("X", SwingConstants.CENTER);
		constraints = new GridBagConstraints();
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.ipadx = 40;
		constraints.ipady = 40;
		frame.add(x, constraints);

		
		//Initializing and positioning nameX Field
		JTextField nameO = new JTextField("Player 2");
		constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.weightx = 1;
		frame.add(nameO, constraints);
		//O Label
		JLabel o = new JLabel("0", SwingConstants.CENTER);
		constraints = new GridBagConstraints();
		constraints.gridx = 1;
		constraints.gridy = 2;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.ipadx = 40;
		constraints.ipady = 40;
		frame.add(o, constraints);
		
		
		//X & 0 buttons panel
		JPanel panel = new JPanel();
		constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.weightx = 1;
		constraints.weighty = 1;
		constraints.gridwidth = 2;
		frame.add(panel, constraints);
		
		currentGame = new TicTacToeGame(nameX, nameO);
		//Initializing the 9 buttons
		panel.setLayout(new GridBagLayout());
		
		for(int row = 0; row < 3; row++) {
			for(int col = 0; col < 3; col++) {
				
				int poz = row * 3 + col;
				
				JButton b = new JButton("   ");
				b.setFocusable(false);
				constraints = new GridBagConstraints();
				constraints.gridx = col;
				constraints.gridy = row;
				constraints.fill = GridBagConstraints.BOTH;
				constraints.weightx = 1;
				constraints.weighty = 1;
				buttons[poz] = b;
				b.addActionListener(new AscultatorButon(frame, currentGame, buttons, b, row, col));
				panel.add(b, constraints);
				
			}
		}
		
		
		//Making the game frame visible
		frame.setVisible(true);
		frame.setSize(300, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
	}
	
	public void replay() {
		int nrCasuteCompletate;
		int[][] solution;
		Scanner input = null;
		
		try {
			input = new Scanner(new File("solution.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		nrCasuteCompletate = input.nextInt();
		solution = new int[nrCasuteCompletate][2];
		for(int i = 0; i < nrCasuteCompletate; i++) {
			solution[i][0] = input.nextInt();
			solution[i][1] = input.nextInt();
		}
		input.close();
		
		delay = 2;
		
		for(int i = 0; i < nrCasuteCompletate; i++) {
			int row = solution[i][0];
			int col = solution[i][1];
			
			if(i % 2 == 0) {
				buttons[row * 3 + col].setEnabled(false);
				buttons[row * 3 + col].setText("X");	
			} else {
				buttons[row * 3 + col].setEnabled(false);
				buttons[row * 3 + col].setText("O");
			}
			
			
			
		}
		
		
		
	}

}
