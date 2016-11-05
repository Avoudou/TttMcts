package abstractSearchComponents;

import abstractDefinitions.AbstractAction;
import abstractDefinitions.SearchState;
import abstractDefinitions.TreeNode;

public class MCTSperformer<State extends SearchState, Action extends AbstractAction<State>> {

	private Playthrough<State, Action> playthrough;
	private Selection<State, Action> selection;

	private NodeGenerator<State, Action> moveGenerator;

	public AbstractAction<State> runMCTS(TreeNode<State, Action> rootNode) {

		return null;

	}

	private boolean checkIfLeafNode(TreeNode<State, Action> aNode) {
		return aNode.getChildrenList().size() == 0;
	}

}
