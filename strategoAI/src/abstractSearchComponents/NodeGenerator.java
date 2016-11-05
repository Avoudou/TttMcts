package abstractSearchComponents;

import abstractDefinitions.AbstractAction;
import abstractDefinitions.SearchState;
import abstractDefinitions.TreeNode;



public abstract class NodeGenerator<State extends SearchState, Action extends AbstractAction<State>> {
	
	
	
	public abstract void generateAvailiableMoves(TreeNode<State, Action> aNode);
}


