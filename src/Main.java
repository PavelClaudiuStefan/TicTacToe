import game.TicTacToe;

/*
 * @author Pavel Claudiu Stefan
 */

public class Main {

	public static void main(String[] args) {
		
		TicTacToe game = new TicTacToe();
		game.start();

		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				System.out.print(j + "" + i + " ");
			}
			System.out.println();
		}
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				System.out.print(j + 3 * i + " ");
			}
			System.out.println();
		}
		
	}

}
