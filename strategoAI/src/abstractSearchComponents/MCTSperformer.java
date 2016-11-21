package abstractSearchComponents;

import java.util.ArrayList;

import variusTests.Logger;
import abstractDefinitions.AbstractAction;
import abstractDefinitions.SearchState;
import abstractDefinitions.TreeNode;

public class MCTSperformer<State extends SearchState, Action extends AbstractAction<State>> {

	private Playthrough<State, Action> playthrough;
	private Selection<State, Action> selection;

	private Rules<State> rules;
	private NodeGenerator<State, Action> moveGenerator;
	private final int noOfItterations = 1000;

	public MCTSperformer(Rules<State> rules, NodeGenerator<State, Action> moveGenerator) {
		this.rules = rules;
		this.moveGenerator = moveGenerator;
		this.playthrough = new Playthrough<State, Action>(moveGenerator, rules);
		this.selection = new Selection<State, Action>();

	}

	public TreeNode<State, Action> runMCTS(TreeNode<State, Action> rootNode) {

		for (int i = 0; i < noOfItterations; i++) {

			mctsItteration(rootNode);

			// Logger.println("number of  Tottal itterations  : " + i);
		}
		// Logger.println("" + rootNode.getGamesPlayed());

		Logger.println(rootNode.getState().toString());

		return getBestChild(rootNode);

	}

	private void mctsItteration(TreeNode<State, Action> rootNode) {
		// Logger.println("start mcts itterattion  (Root  times played): " + rootNode.getGamesPlayed());
		TreeNode<State, Action> visititedNode = rootNode;

		while (!checkIfLeafNode(visititedNode)) {
			visititedNode = selection.selectChild(visititedNode);
			// Logger.println("searching for child node depth  :" + visititedNode.getNodeDepth());
		}

		// Logger.println("Leaf node #of available moves  : " + moves.size());
		if (rules.isTerminal(visititedNode)) {
			// System.out.println("terminal node");

			int result = playthrough.returnPlaythroughResult(visititedNode);

			updateTree(visititedNode, result);

			return;
		}
		ArrayList<TreeNode<State, Action>> moves = moveGenerator.generateAvailiableMoves(visititedNode);

		visititedNode.setChildrenList(moves);
		visititedNode = selection.selectChild(visititedNode);
		int result = playthrough.returnPlaythroughResult(visititedNode);
		// Logger.println("playthrough result: " + result);
		updateTree(visititedNode, result);
		// Logger.println("end mcts itterattion  (Root  times played): " + rootNode.getGamesPlayed());

	}

	private boolean checkIfLeafNode(TreeNode<State, Action> aNode) {
		// System.out.println("size " + aNode.getChildrenList().size());
		return aNode.getChildrenList().size() == 0;
	}

	private void updateTree(TreeNode<State, Action> visitNode, int result) {
		TreeNode<State, Action> tempNode = visitNode;
		singleNodeUpdate(visitNode, result);
		while (tempNode.getParent() != null) {
			tempNode = tempNode.getParent();
			singleNodeUpdate(tempNode, result);

		}
	}

	private void singleNodeUpdate(TreeNode<State, Action> visitNode, int leafPlaythroughResult) {
		// TODO Untested
		if (visitNode.getNodeDepth() % 2 == 0) {
			leafPlaythroughResult *= -1;
		}
		int effectiveResult = leafPlaythroughResult + 1;
		visitNode.setGamesPlayed(visitNode.getGamesPlayed() + 2);
		

		visitNode.setGamesWon(visitNode.getGamesWon() + effectiveResult);

		
	}

	private TreeNode<State, Action> getBestChild(TreeNode<State, Action> aNode) {

		Logger.println(aNode.getState().toString());
		ArrayList<TreeNode<State, Action>> childNodes = aNode.getChildrenList();
		TreeNode<State, Action> tempBestChild = childNodes.get(0);

		double tempCounter = 0;
		if (tempBestChild.getGamesPlayed() != 0) {
			tempCounter = childNodes.get(0).getGamesWon() / childNodes.get(0).getGamesPlayed();
		} else {
			tempCounter = 0;
		}

		for (int i = 0; i < childNodes.size(); i++) {

			double compare = 0;

			if (childNodes.get(i).getGamesPlayed() != 0) {
				compare = 1.0*childNodes.get(i).getGamesWon() / childNodes.get(i).getGamesPlayed();
			} else {
				compare = 0;
			}
			Logger.println(childNodes.get(i).getAction() + " won " + childNodes.get(i).getGamesWon() + " played "
					+ childNodes.get(i).getGamesPlayed());

			if (compare > tempCounter) {
				tempCounter = compare;
				tempBestChild = childNodes.get(i);
			}
		}
		
		
		// Logger.println(""+tempBestChild.getGamesWon());
		return tempBestChild;
	}

}
