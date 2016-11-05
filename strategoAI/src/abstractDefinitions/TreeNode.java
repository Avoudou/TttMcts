package abstractDefinitions;

import java.util.ArrayList;
import java.util.List;

public class TreeNode<State extends SearchState, Action extends AbstractAction<State>> {

	private SearchState state;

	private AbstractAction action;

	private ArrayList<TreeNode<State, Action>> childrenList;

	private int nodeDepth;

	/** Value of the Node */
	// private double valueOfNode;

	private int gamesPlayed;
	private int gamesWon;

	public TreeNode(SearchState rootState) {

		this.state = rootState;
	}

	public ArrayList<TreeNode<State, Action>> getChildrenList() {
		return childrenList;
	}

	public void setChildrenList(List<TreeNode<State, Action>> childrenList) {
		this.childrenList = (ArrayList<TreeNode<State, Action>>) childrenList;
	}

	public int getGamesPlayed() {
		return gamesPlayed;
	}

	public void setGamesPlayed(int gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}

	public int getGamesWon() {
		return gamesWon;
	}

	public void setGamesWon(int gamesWon) {
		this.gamesWon = gamesWon;
	}

}
