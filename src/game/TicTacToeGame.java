package game;

public class TicTacToeGame {
	
	String currentTurn = "X";
	

	
	public String getTurn() {
		return currentTurn;
	}
	
	public void clickedAt(int row, int col) {
		if(currentTurn == "X") {
			currentTurn = "O";
		} else {
			currentTurn = "X";
		}
		System.out.println(row + " " + col);
	}
	
	
}
