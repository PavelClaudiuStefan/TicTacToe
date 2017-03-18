package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class AscultatorButon implements ActionListener {

	int row, col;
	JButton b;
	TicTacToeGame currentGame;
	
	public AscultatorButon(TicTacToeGame currentGame, JButton b, int row, int col) {
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
		
	}

}
