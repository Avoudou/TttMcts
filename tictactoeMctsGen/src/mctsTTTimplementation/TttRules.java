package mctsTTTimplementation;

import tictactoeMain.Logger;
import tictactoeMain.TttGame;
import tictactoeMain.TttLogic;
import abstractDefinitions.TreeNode;
import abstractSearchComponents.Rules;

public class TttRules extends Rules<TttGame> {

	TttLogic logic;


	public TttRules(TttLogic logic) {
		super();
		this.logic = logic;
	}

	@Override
	public boolean isTerminal(TreeNode<TttGame, ?> aNode) {
		TttGame game = (TttGame) aNode.getState();
		int[][ ] board= game.getBoard().getBoard();
	
		
		if (logic.checkForWinner(game)) {
			return true;

		}
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 0) {
					return false;
				}

			}
		}
		
		return true;
	}

	@Override
	public int getScoreValue(TreeNode<TttGame, ?> aNode, int refereance) {

		TttGame game = aNode.getState();
		int playerSymbol = refereance;
		

		// Logger.println("player symbol at root : " + playerSymbol + " X " + game.getPlayerX().getSymbolPlaying() +
		// " O "
		// + game.getPlayerO().getSymbolPlaying() + " ND " + aNode.getNodeDepth() + " Rd "
		// + aNode.getRootNode().getNodeDepth());
		
		if (logic.checkWinForPlayerSynbol(game, playerSymbol)) {

			return 1;
		}
		if (logic.checkWinForPlayerSynbol(game, game.getOpponentPlayer().getSymbolPlaying())) {
			Logger.println("-1 playthrough result");
			return -1;
		}
		return 0;


	}

}