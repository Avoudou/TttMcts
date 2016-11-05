package abstractSearchComponents;

import java.util.ArrayList;

import abstractDefinitions.AbstractAction;
import abstractDefinitions.SearchState;
import abstractDefinitions.TreeNode;

public class Selection<State extends SearchState, Action extends AbstractAction<State>> {
	
	
	public TreeNode<State, Action> selectChild(TreeNode<State, Action> aNode) {
		
		ArrayList<TreeNode<State, Action>> childrenList = aNode.getChildrenList();
		
		int[] spaceIndervalOfProbability = new int[childrenList.size()];
		int probabilityTottal = 0;
		
		for (int i=0;i<spaceIndervalOfProbability.length;i++){
			int aNodeProbability = 1 + childrenList.get(i).getGamesWon();
			spaceIndervalOfProbability[i] = aNodeProbability;
			probabilityTottal = probabilityTottal + aNodeProbability;
		}
		int randomSelectionGenerator = (int) (probabilityTottal * Math.random());

		int indexTempSearch = 0;
		for (int j = 0; j < spaceIndervalOfProbability.length; j++) {
			indexTempSearch = indexTempSearch + spaceIndervalOfProbability[j];

			if (indexTempSearch >= randomSelectionGenerator) {
				return childrenList.get(j);
			}

		}

		System.out.println("something VERY wrong in selection");
		return null;
	}
		
	

}
