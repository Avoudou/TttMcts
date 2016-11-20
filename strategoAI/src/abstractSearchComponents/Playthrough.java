package abstractSearchComponents;

import java.util.ArrayList;

import abstractDefinitions.AbstractAction;
import abstractDefinitions.SearchState;
import abstractDefinitions.TreeNode;

public class Playthrough<State extends SearchState, Action extends AbstractAction<State>> {

	private NodeGenerator<State, Action> nodeGenerator;
	private Rules<State> rules;

	public Playthrough(NodeGenerator<State, Action> nodeGenerator,Rules<State> rules) {
		this.nodeGenerator = nodeGenerator;
		this.rules = rules;
	}
	
	

	public int returnPlaythroughResult(TreeNode<State, Action> leafNode) {
		@SuppressWarnings("unchecked")
		TreeNode<State, Action> tempNode = new TreeNode<State, Action>((State) leafNode.getState().deepCopySelf());
		// tempNode.setParent(leafNode);
		tempNode.setPlaythoughNode(true);
		// tempNode.setParent(leafNode.getParent());
		TreeNode<State, Action> rootNode = leafNode.getRootNode();
		int referance= rootNode.getState().getActivePlayer();
		int activeplayer = leafNode.getState().getActivePlayer();
		while (!rules.isTerminal(tempNode)) {
			ArrayList<TreeNode<State, Action>> childrenNodes = nodeGenerator.generateAvailiableMoves(tempNode);
			// tempNode.setChildrenList(childrenNodes);
			tempNode = childrenNodes.get((int) (Math.random() * childrenNodes.size()));
			if (tempNode.getState().getActivePlayer() == activeplayer) {
				System.out.println("some problems");

			} else {
				System.out.println(" no problems");
			}
			activeplayer = tempNode.getState().getActivePlayer();
		}
		
		return rules.getScoreValue(tempNode, referance);
	}

}
