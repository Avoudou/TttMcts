package abstractSearchComponents;

import java.util.ArrayList;

import abstractDefinitions.AbstractAction;
import abstractDefinitions.SearchState;
import abstractDefinitions.TreeNode;



public abstract class NodeGenerator<State extends SearchState, Action extends AbstractAction<State>> {
	
	
	
	public abstract ArrayList<TreeNode<State, Action>> generateAvailiableMoves(TreeNode<State, Action> aNode);
}


