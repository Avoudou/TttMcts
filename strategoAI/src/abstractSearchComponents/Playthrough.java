package abstractSearchComponents;

import java.util.ArrayList;

import abstractDefinitions.AbstractAction;
import abstractDefinitions.SearchState;
import abstractDefinitions.TreeNode;

public class Playthrough<State extends SearchState, Action extends AbstractAction<State>> {

	private MoveGenerator<State, Action> nodeGenerator;
	private Rules<State> rules;

	public Playthrough(MoveGenerator<State, Action> nodeGenerator, Rules<State> rules) {
		this.nodeGenerator = nodeGenerator;
		this.rules = rules;
	}
	
	

	public double returnPlaythroughResult(TreeNode<State, Action> leafNode) {
		@SuppressWarnings("unchecked")

		State state = (State) leafNode.getState().deepCopySelf();

		// tempNode.setPlaythoughNode(true);
		
		TreeNode<State, Action> rootNode = leafNode.getRootNode();
		int referance= rootNode.getState().getActivePlayer();

		while (!rules.isTerminal(state)) {
			ArrayList<Action> childrenNodes = nodeGenerator.generateAvailiableMoves(state);

			nodeGenerator.applyAction(state, childrenNodes.get((int) (childrenNodes.size() * Math.random())));
		
		
		}
		return rules.getScoreValue(state, referance);
	}
	
	

}
