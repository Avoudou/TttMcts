package mctsTTTimplementation;

import java.util.ArrayList;

import tictactoeMain.Logger;
import tictactoeMain.TttGame;
import tictactoeMain.TttLogic;
import abstractDefinitions.TreeNode;
import abstractSearchComponents.NodeGenerator;
import eventPck.TttActionEvent;

public class TttNodeGenerator extends NodeGenerator<TttGame, TttActionEvent> {

	private TttLogic logic;

	public TttNodeGenerator(TttLogic logic) {
		this.logic = logic;
	}

	@Override
	public ArrayList<TreeNode<TttGame, TttActionEvent>> generateAvailiableMoves(TreeNode<TttGame, TttActionEvent> aNode) {
		TttGame game = (TttGame) aNode.getState();

		ArrayList<TreeNode<TttGame, TttActionEvent>> returnNodesList = new ArrayList<TreeNode<TttGame, TttActionEvent>>();

		int[][] board = game.getBoard().getBoard();

		ArrayList<TttActionEvent> availiableActions = new ArrayList<TttActionEvent>();

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 0) {
					availiableActions.add(new TttActionEvent(j, i));
				}

			}
		}

		for (int i = 0; i < availiableActions.size(); i++) {
			TttGame newState = game.deepCopySelf();
			if (newState.getBoard().getBoard() == game.getBoard().getBoard()) {
				Logger.println("VERY VERY bad");
			}
			logic.processEvent(availiableActions.get(i), newState);
			if (newState.getActivePlayer() == game.getActivePlayer()) {
				Logger.println("Deep problems");
			}
			// logic.processEvent(new TttChangeActivePlayerEvent(), newState);
			TreeNode<TttGame, TttActionEvent> newNode = new TreeNode<TttGame, TttActionEvent>(newState);
			newNode.setParent(aNode);
			aNode.getChildrenList().add(newNode);
			newNode.setNodeDepth(aNode.getNodeDepth() + 1);
			newNode.setAction(availiableActions.get(i));
			newNode.setPlaythoughNode(aNode.isPlaythoughNode());
			returnNodesList.add(newNode);

		}
		// Logger.println(" child nodes generated");
		return returnNodesList;
	}


}
