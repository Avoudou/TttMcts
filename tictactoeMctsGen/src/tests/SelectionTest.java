package tests;

import mctsTTTimplementation.TttNodeGenerator;
import tictactoeMain.Logger;
import tictactoeMain.TttGame;
import tictactoeMain.TttLogic;
import abstractDefinitions.TreeNode;
import abstractSearchComponents.NodeGenerator;
import abstractSearchComponents.Selection;
import eventPck.TttActionEvent;

public class SelectionTest {

	public static void main(String[] args) {
		Selection<TttGame, TttActionEvent> selection = new Selection<TttGame, TttActionEvent>();
		TreeNode<TttGame, TttActionEvent> root = new TreeNode<TttGame, TttActionEvent>(new TttGame());

		NodeGenerator<TttGame, TttActionEvent> generator = new TttNodeGenerator(new TttLogic());

		root.setChildrenList(generator.generateAvailiableMoves(root));
		Logger.println("" + root.getChildrenList().size());
		Logger.println("" + selection.selectChild(root));

	}


}
