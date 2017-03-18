package game;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class TicTacToe {
	
	public void start() {

		TicTacToeGame currentGame = new TicTacToeGame();
		GridBagConstraints constraints;
		
		JFrame frame = new JFrame();
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
		
		//Initializing the 9 buttons
		panel.setLayout(new GridBagLayout());
		for(int col = 0; col < 3; col++) {
			for(int row = 0; row < 3; row++) {
				
				JButton b = new JButton("");
				constraints = new GridBagConstraints();
				constraints.gridx = row;
				constraints.gridy = col;
				constraints.fill = GridBagConstraints.BOTH;
				constraints.weightx = 1;
				constraints.weighty = 1;
				b.addActionListener(new AscultatorButon(currentGame, b, row, col));
				panel.add(b, constraints);
				
			}
		}

		
		//Initializing and positioning nameX Field
		JTextField nameY = new JTextField("Player 2");
		constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.weightx = 1;
		frame.add(nameY, constraints);
		//O Label
		JLabel o = new JLabel("0", SwingConstants.CENTER);
		constraints = new GridBagConstraints();
		constraints.gridx = 1;
		constraints.gridy = 2;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.ipadx = 40;
		constraints.ipady = 40;
		frame.add(o, constraints);
		
		
		//Making the game frame visible
		frame.setVisible(true);
        frame.setBounds(100,100,300,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
	}
}
