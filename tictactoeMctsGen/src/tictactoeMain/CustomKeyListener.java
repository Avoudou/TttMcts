package tictactoeMain;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import mctsTTTimplementation.TttNodeGenerator;
import mctsTTTimplementation.TttRules;
import variusTests.Logger;
import abstractDefinitions.TreeNode;
import abstractSearchComponents.MCTSperformer;
import eventPck.TttActionEvent;
import eventPck.TttChangeActivePlayerEvent;

public class CustomKeyListener implements KeyListener {

	private TttGame game;
	private TttLogic logic;
	private MCTSperformer<TttGame, TttActionEvent> mctsPerformer;

	public CustomKeyListener(TttGame game, TttLogic logic) {
		this.game = game;
		this.logic = logic;
		this.mctsPerformer = new MCTSperformer<TttGame, TttActionEvent>(new TttRules(logic),
				new TttNodeGenerator(logic));
	}

	public void keyTyped(KeyEvent e) {

	}

	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_NUMPAD1) {
			moveProcess(2, 0);

		}
		if (e.getKeyCode() == KeyEvent.VK_NUMPAD2) {
			moveProcess(2, 1);

		}

		if (e.getKeyCode() == KeyEvent.VK_NUMPAD3) {
			moveProcess(2, 2);

		}
		if (e.getKeyCode() == KeyEvent.VK_NUMPAD4) {
			moveProcess(1, 0);

		}
		if (e.getKeyCode() == KeyEvent.VK_NUMPAD5) {
			moveProcess(1, 1);
			;

		}
		if (e.getKeyCode() == KeyEvent.VK_NUMPAD6) {
			moveProcess(1, 2);

		}
		if (e.getKeyCode() == KeyEvent.VK_NUMPAD7) {
			moveProcess(0, 0);

		}
		if (e.getKeyCode() == KeyEvent.VK_NUMPAD8) {
			moveProcess(0, 1);

		}
		if (e.getKeyCode() == KeyEvent.VK_NUMPAD9) {
			moveProcess(0, 2);

		}
		if (e.getKeyCode() == KeyEvent.VK_PAGE_UP) {
			logic.changeActivePlayer(new TttChangeActivePlayerEvent(), game);

		}
		if (e.getKeyCode() == KeyEvent.VK_INSERT) {
			TreeNode<TttGame, TttActionEvent> rootNode = new TreeNode<TttGame, TttActionEvent>(game);

			int playerSymbol = rootNode.getState().getActiveTttPlayer().getSymbolPlaying();
			Logger.println("player symbol at root : " + playerSymbol + " X " + game.getPlayerX().getSymbolPlaying()
					+ " O " + game.getPlayerO().getSymbolPlaying());

			TttActionEvent chosenMove = (TttActionEvent) mctsPerformer.runMCTS(rootNode).getAction();
			moveProcess(chosenMove);

		}

	}

	private void moveProcess(int yTarget, int xTarget) {
		logic.processEvent(new TttActionEvent(xTarget, yTarget), game);
		System.out.println();
		print2DArray(game.getBoard().getBoard());
		System.out.println();
		logic.checkForWinner(game);
	}

	private void moveProcess(TttActionEvent event) {
		logic.processEvent(event, game);
		System.out.println();
		print2DArray(game.getBoard().getBoard());
		System.out.println();
		logic.checkForWinner(game);
	}
	// need for no exceptions
	public void keyReleased(KeyEvent e) {

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