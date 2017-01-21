package mctsTTTimplementation;

import project.stratego.ai.mcts.abstractDefinitions.TreeNode;
import project.stratego.ai.mcts.abstractSearchComponents.Rules;
import tictactoeMain.Logger;
import tictactoeMain.TttGame;
import tictactoeMain.TttLogic;

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

	@Override
	public boolean isTerminal(TttGame aState) {
		int[][] board = aState.getBoard().getBoard();

		if (logic.checkForWinner(aState)) {
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
	public double getScoreValue(TttGame state, int referance) {
		int playerSymbol = referance;

		if (logic.checkWinForPlayerSynbol(state, playerSymbol)) {

			return 1;
		}
		if (logic.checkWinForPlayerSynbol(state, state.getOpponentPlayer().getSymbolPlaying())) {
			Logger.println("-1 playthrough result");
			return -1;
		}
		return 0;

	}

}
