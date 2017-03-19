package game;

public class TicTacToeGame {
	
	String 	currentTurn, 
			winner,
			nameX,
			nameO;
	int casuteCompletate;
	
	//0 = default, 1 = X, -1 = O
	int[][] gameBoard = new int[3][3];
	
	public TicTacToeGame(String nameX, String nameO) {
		this.nameX = nameX;
		this.nameO = nameO;
		currentTurn = "X";
		winner = "Draw!";
		casuteCompletate = 0;
	
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				gameBoard[i][j] = 0;
			}
		}
	}
	
	public String getTurn() {
		return currentTurn;
	}
	
	public void clickedAt(int row, int col) {
		
		if(currentTurn == "X") {
			
			gameBoard[row][col] = 1;
			currentTurn = "O";	
		} else {
			
			gameBoard[row][col] = -1;
			currentTurn = "X";	
		}
		
		casuteCompletate++;
	}
	
	public boolean over() {
		
		if (	
			gameBoard[0][0] + gameBoard[0][1] + gameBoard[0][2] == 3 ||
			gameBoard[1][0] + gameBoard[1][1] + gameBoard[1][2] == 3 ||
			gameBoard[2][0] + gameBoard[2][1] + gameBoard[2][2] == 3 ||
			gameBoard[0][0] + gameBoard[1][0] + gameBoard[2][0] == 3 ||
			gameBoard[0][1] + gameBoard[1][1] + gameBoard[2][1] == 3 ||
			gameBoard[0][2] + gameBoard[1][2] + gameBoard[2][2] == 3 ||
			gameBoard[0][0] + gameBoard[1][1] + gameBoard[2][2] == 3 ||
			gameBoard[0][2] + gameBoard[1][1] + gameBoard[2][0] == 3 ) {
			
			winner = nameX + " won!";
			return true;
			
		} else if (
			gameBoard[0][0] + gameBoard[0][1] + gameBoard[0][2] == 3 ||
			gameBoard[1][0] + gameBoard[1][1] + gameBoard[1][2] == 3 ||
			gameBoard[2][0] + gameBoard[2][1] + gameBoard[2][2] == 3 ||
			gameBoard[0][0] + gameBoard[1][0] + gameBoard[2][0] == 3 ||
			gameBoard[0][1] + gameBoard[1][1] + gameBoard[2][1] == 3 ||
			gameBoard[0][2] + gameBoard[1][2] + gameBoard[2][2] == 3 ||
			gameBoard[0][0] + gameBoard[1][1] + gameBoard[2][2] == 3 ||
			gameBoard[0][2] + gameBoard[1][1] + gameBoard[2][0] == 3 ) {
			
			winner = nameO + " won!";
			return true;
			
		}
		
		if(casuteCompletate == 9) {
			return true;
		}
		return false;
	}
	
	public String winner() {
		return winner;
	}
	
	
}
