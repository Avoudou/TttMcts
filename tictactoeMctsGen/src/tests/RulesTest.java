package tests;

import mctsTTTimplementation.TttNodeGenerator;
import mctsTTTimplementation.TttRules;
import tictactoeMain.TttGame;
import tictactoeMain.TttLogic;
import abstractDefinitions.TreeNode;
import abstractSearchComponents.MoveGenerator;
import abstractSearchComponents.Playthrough;
import abstractSearchComponents.Selection;
import eventPck.TttActionEvent;

public class RulesTest {

	public static void main(String[] args) {

		TttGame game = new TttGame();
		Selection<TttGame, TttActionEvent> selection = new Selection<TttGame, TttActionEvent>();
		TreeNode<TttGame, TttActionEvent> root = new TreeNode<TttGame, TttActionEvent>(game);
		TttLogic logic = new TttLogic();
		MoveGenerator<TttGame, TttActionEvent> generator = new TttNodeGenerator(logic);
		TttRules rules = new TttRules(logic);
		// logic.changeActivePlayer(new TttChangeActivePlayerEvent(), game);
		logic.processEvent(new TttActionEvent(0, 1), game);
		logic.processEvent(new TttActionEvent(2, 2), game);
		logic.processEvent(new TttActionEvent(1, 1), game);
		logic.processEvent(new TttActionEvent(2, 0), game);
		logic.processEvent(new TttActionEvent(2, 1), game);
		// logic.changeActivePlayer(new TttChangeActivePlayerEvent(), game);



		print2DArray(game.getBoard().getBoard());
		System.out.println();
		// System.out.println("score : " + rules.getScoreValue(root));
		
		Playthrough<TttGame, TttActionEvent> playthrough = new Playthrough<TttGame, TttActionEvent>(generator, rules);

		System.out.println(rules.isTerminal(root));
		System.out.println(playthrough.returnPlaythroughResult(root));

	}

	public static void print2DArray(int[][] array2D) {

		for (int i = 0; i < array2D.length; i++) {
			System.out.println();
			for (int j = 0; j < array2D[i].length; j++) {
				System.out.print(array2D[i][j] + " ");
			}
		}

	}

}
