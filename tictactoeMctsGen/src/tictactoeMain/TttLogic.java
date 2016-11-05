package tictactoeMain;

import eventPck.TttActionEvent;
import eventPck.TttChangeActivePlayerEvent;
import eventPck.TttEvent;

public class TttLogic {

	public void processEvent(TttEvent anEvent, TttGame game) {
		if (anEvent.getClass() == TttActionEvent.class) {
			applyAction((TttActionEvent) anEvent, game);
			checkForWinner(game);
			// changeActivePlayer(new TttChangeActivePlayerEvent(), game);
		}

	}



	public boolean checkForWinner(TttGame game) {
		int tempRefereanceCheck;
		tempRefereanceCheck = game.getPlayerX().getSymbolPlaying();
		if (checkWinForPlayerSynbol(game, tempRefereanceCheck)) {
			return checkWinForPlayerSynbol(game, tempRefereanceCheck);
		}
		tempRefereanceCheck = game.getPlayerO().getSymbolPlaying();
		if (checkWinForPlayerSynbol(game, tempRefereanceCheck)) {
			return checkWinForPlayerSynbol(game, tempRefereanceCheck);
		}

		return false;
	}

	private void applyAction(TttActionEvent event, TttGame game) {
		if (!checkIfValidAction(event, game)) {
			return;
		}
		game.getBoard().getBoard()[event.getTargetY()][event.getTargetX()] = game.getActivePlayer().getSymbolPlaying();

	}

	private boolean checkWinForPlayerSynbol(TttGame game, int tempRefereanceCheck) {
		for (int i = 0; i < game.getBoard().getBoard().length; i++) {
			if (game.getBoard().getBoard()[i][0] == tempRefereanceCheck
					&& game.getBoard().getBoard()[i][1] == tempRefereanceCheck
					&& game.getBoard().getBoard()[i][2] == tempRefereanceCheck) {
				System.out.println("player " + tempRefereanceCheck + " wins");
				return true;
					
				}
				
			}
		for (int i = 0; i < game.getBoard().getBoard()[0].length; i++) {
			if (game.getBoard().getBoard()[0][i] == tempRefereanceCheck
					&& game.getBoard().getBoard()[1][i] == tempRefereanceCheck
					&& game.getBoard().getBoard()[2][i] == tempRefereanceCheck) {
				System.out.println("player " + tempRefereanceCheck + " wins");
				return true;

			}

		}
		
		if(game.getBoard().getBoard()[0][0]==tempRefereanceCheck && game.getBoard().getBoard()[1][1]==tempRefereanceCheck && game.getBoard().getBoard()[2][2]==tempRefereanceCheck ){
			System.out.println("player " + tempRefereanceCheck + " wins");
			return true;

		}
		if (game.getBoard().getBoard()[0][2] == tempRefereanceCheck
				&& game.getBoard().getBoard()[1][1] == tempRefereanceCheck
				&& game.getBoard().getBoard()[2][0] == tempRefereanceCheck) {
			System.out.println("player " + tempRefereanceCheck + " wins");
			return true;

		}
		return false;
	}

	private boolean checkIfValidAction(TttActionEvent event, TttGame game) {
		if (event.getTargetX() > 2 || event.getTargetX() < 0) {
			return false;
		}
		if (event.getTargetY() > 2 || event.getTargetY() < 0) {
			return false;
		}

		if (game.getBoard().getBoard()[event.getTargetY()][event.getTargetX()] != 0) {
			System.out.println("possition accupied");
			return false;
		}

		return true;

	}

	public void changeActivePlayer(TttChangeActivePlayerEvent event, TttGame game) {
		if (game.getActivePlayer() == game.getPlayerO()) {
			game.setActivePlayer(game.getPlayerX());
		} else {
			game.setActivePlayer(game.getPlayerO());
		}
		System.out.println();
		System.out.println("Active player  is now Player " + game.getActivePlayer().getSymbolPlaying());


	}


}
