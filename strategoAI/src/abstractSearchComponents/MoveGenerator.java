package abstractSearchComponents;

import java.util.ArrayList;

import abstractDefinitions.AbstractAction;
import abstractDefinitions.SearchState;



public abstract class MoveGenerator<State extends SearchState, Action extends AbstractAction<State>> {
	
	
	
	public abstract ArrayList<Action> generateAvailiableMoves(State state);

	public abstract void applyAction(State state, Action action);
}


