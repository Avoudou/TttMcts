package tictactoeMain;

public class TttBoard {

	private int[][] board;

	public TttBoard() {
		board = new int[3][3];
	}

	public TttBoard(int[][] boardRep) {
		this.board = boardRep;
	}

	public int[][] getBoard() {
		return board;
	}

	public void setBoard(int[][] boardRep) {
		this.board = boardRep;
	}
}
