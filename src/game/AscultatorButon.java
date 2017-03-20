package game;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AscultatorButon implements ActionListener {

	int row, col;
	JButton[] buttons;
	JButton b;
	TicTacToeGame currentGame;
	JFrame frame;
	
	public AscultatorButon(JFrame frame, TicTacToeGame currentGame, JButton[] buttons, JButton b, int row, int col) {
		this.frame = frame;
		this.currentGame = currentGame;
		this.buttons = buttons;
		this.b = b;
		this.row = row;
		this.col = col;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		b.setText(currentGame.getTurn());
		currentGame.clickedAt(row, col);
		b.setEnabled(false);
		
		if(currentGame.over()) {
			//JOptionPane.showMessageDialog(frame, currentGame.winner());
			JDialog dialog = new JDialog();
			dialog.setLayout(new GridBagLayout());
			dialog.setTitle("Game over");
			dialog.setSize(300,  200);
			dialog.setLocationRelativeTo(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			
			JLabel winnerText = new JLabel(currentGame.winner());
			GridBagConstraints constraints = new GridBagConstraints();
			constraints.gridy = 0;
			constraints.weighty = 1;
			dialog.add(winnerText, constraints);
			
			JLabel outputFileName = new JLabel("Game saved in \"solution.txt\"");
			constraints = new GridBagConstraints();
			constraints.gridy = 1;
			constraints.weighty = 1;
			dialog.add(outputFileName, constraints);
			
			JLabel resetText = new JLabel("New game?");
			constraints = new GridBagConstraints();
			constraints.gridy = 2;
			constraints.weighty = 1;
			dialog.add(resetText, constraints);
			
			JButton butonOk = new JButton("Ok");
			constraints = new GridBagConstraints();
			constraints.gridy = 3;
			constraints.weighty = 1;
			butonOk.setSize(50, 50);
			butonOk.setFocusable(false);
			butonOk.addActionListener( new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					currentGame.reset();
					for(int i = 0; i < 9; i++) {
						buttons[i].setText("   ");
						buttons[i].setEnabled(true);
					}
					dialog.dispose();
				}
			});
			
			dialog.add(butonOk, constraints);
			
		}
		
	}

}
