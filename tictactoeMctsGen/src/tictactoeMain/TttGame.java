package tictactoeMain;

import abstractDefinitions.SearchState;

public class TttGame extends SearchState {

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

	public TttGame(TttBoard aBoard) {
		this.board = aBoard;
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

	public TttPlayer getActiveTttPlayer() {
		return activePlayer;
	}

	public void setActivePlayer(TttPlayer activePlayer) {
		this.activePlayer = activePlayer;
	}

	public TttGame deepCopySelf() {
		


		int[][] newBoard = new int[board.getBoard().length][board.getBoard()[0].length];

		for (int i = 0; i < newBoard.length; i++) {
			for (int j = 0; j < newBoard[0].length; j++) {
				newBoard[i][j] = board.getBoard()[i][j];
			}
		}

		TttGame newCopy = new TttGame(new TttBoard(newBoard));
		newCopy.setPlayerO(new TttPlayer(this.playerO.getSymbolPlaying()));
		newCopy.setPlayerX((new TttPlayer(this.playerX.getSymbolPlaying())));
		newCopy.setActivePlayer(this.activePlayer);

		return newCopy;

	}

	public TttPlayer getOpponentPlayer(){
		if(activePlayer.getSymbolPlaying()==playerX.getSymbolPlaying()){
			return playerO;
		}else
			return playerX;
	}

	private void setPlayerX(TttPlayer aPlayer) {
		this.playerX = aPlayer;
	}

	private void setPlayerO(TttPlayer aPlayer) {
		this.playerO = aPlayer;

	}

	@Override
	public String toString() {
		String result = "";
		int[][] b = board.getBoard();
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				result += b[i][j];
			}
			result += "\n";
		}
		return result;
	}

	@Override
	public int getActivePlayer() {

		return activePlayer.getSymbolPlaying();
	}
}
