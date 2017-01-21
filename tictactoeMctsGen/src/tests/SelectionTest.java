package tests;

import project.stratego.ai.mcts.abstractDefinitions.TreeNode;
import project.stratego.ai.mcts.abstractSearchComponents.MoveGenerator;
import project.stratego.ai.mcts.abstractSearchComponents.Selection;
import mctsTTTimplementation.TttNodeGenerator;
import tictactoeMain.Logger;
import tictactoeMain.TttGame;
import tictactoeMain.TttLogic;
import eventPck.TttActionEvent;

public class SelectionTest {

	public static void main(String[] args) {
		Selection<TttGame, TttActionEvent> selection = new Selection<TttGame, TttActionEvent>();
		TreeNode<TttGame, TttActionEvent> root = new TreeNode<TttGame, TttActionEvent>(new TttGame());

		MoveGenerator<TttGame, TttActionEvent> generator = new TttNodeGenerator(new TttLogic());

		// /root.setChildrenList(generator.generateAvailiableMoves(root));
		Logger.println("" + root.getChildrenList().size());
		Logger.println("" + selection.selectChild(root));

	}


}
