package tictactoeMain;

public class TttGame {

	private TttPlayer playerX;
	private TttPlayer playerO;

	private TttPlayer activePlayer;
	private TttBoard board;

	public TttGame() {
		board = new TttBoard();
		playerX = new TttPlayer(1);
		playerO = new TttPlayer(2);
		setActivePlayer(playerX);
	}

	public TttPlayer getPlayerX() {
		return playerX;
	}

	public TttPlayer getPlayerO() {
		return playerO;
	}

	public TttBoard getBoard() {
		return board;
	}

	public TttPlayer getActivePlayer() {
		return activePlayer;
	}

	public void setActivePlayer(TttPlayer activePlayer) {
		this.activePlayer = activePlayer;
	}

}
