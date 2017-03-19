package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AscultatorButon implements ActionListener {

	int row, col;
	JButton b;
	TicTacToeGame currentGame;
	JFrame frame;
	
	public AscultatorButon(JFrame frame, TicTacToeGame currentGame, JButton b, int row, int col) {
		this.frame = frame;
		this.currentGame = currentGame;
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
			JOptionPane.showMessageDialog(frame, currentGame.winner());
		}
		
	}

}
