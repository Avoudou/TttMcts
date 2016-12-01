package abstractSearchComponents;

import abstractDefinitions.SearchState;
import abstractDefinitions.TreeNode;

public  abstract class Rules<State extends SearchState> {
	
	public abstract boolean isTerminal(TreeNode<State, ?> aNode);

	public abstract boolean isTerminal(State aState);

	public abstract int getScoreValue(TreeNode<State, ?> aNode, int referance);

	public abstract int getScoreValue(State state, int referance);

}


