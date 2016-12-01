package tictactoeMain;

import javax.swing.JFrame;
import javax.swing.JPanel;

import mctsTTTimplementation.TttNodeGenerator;
import mctsTTTimplementation.TttRules;
import abstractDefinitions.TreeNode;
import eventPck.TttActionEvent;

public class TttMainMethod {

	public static void main(String args[]) {

		TttGame game = new TttGame();
		TttLogic logic = new TttLogic();
		// logic.processEvent(new TttActionEvent(0, 1), game);
		// logic.processEvent(new TttActionEvent(1, 0), game);
		// logic.processEvent(new TttActionEvent(0, 2), game);
		// logic.processEvent(new TttActionEvent(2, 0), game);
		// logic.processEvent(new TttActionEvent(1, 2), game);
		// logic.processEvent(new TttActionEvent(1, 1), game);

		// logic.processEvent(new TttActionEvent(2, 1), game);
		// logic.processEvent(new TttActionEvent(0, 1), game);

		TttRules rules = new TttRules(logic);
		TreeNode<TttGame, TttActionEvent> aNode = new TreeNode<TttGame, TttActionEvent>(game);
		System.out.println(rules.isTerminal(aNode));
		TttNodeGenerator generator = new TttNodeGenerator(logic);
		// ArrayList<TreeNode<TttGame, TttActionEvent>> childsList = generator.generateAvailiableMoves(aNode);
		// System.out.println(childsList.size());
		JFrame window = new JFrame();

		window.setSize(100, 100);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		JPanel panel = new JPanel();
		CustomKeyListener listener = new CustomKeyListener(game, logic);
		panel.addKeyListener(listener);

		panel.setFocusable(true);
		window.add(panel);

		window.setVisible(true);
		print2DArray(game.getBoard().getBoard());


	


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
