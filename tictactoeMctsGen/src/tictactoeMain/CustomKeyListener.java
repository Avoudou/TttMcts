package tictactoeMain;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import eventPck.TttActionEvent;
import eventPck.TttChangeActivePlayerEvent;

public class CustomKeyListener implements KeyListener {

	private TttGame game;
	private TttLogic logic;

	public CustomKeyListener(TttGame game, TttLogic logic) {
		this.game = game;
		this.logic = logic;
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
	}

	private void moveProcess(int yTarget, int xTarget) {
		logic.processEvent(new TttActionEvent(xTarget, yTarget), game);
		System.out.println();
		print2DArray(game.getBoard().getBoard());
		System.out.println();
		logic.checkForWinner(game);
	}

	// need for no exceptions
	public void keyReleased(KeyEvent e) {

	}

	private void print2DArray(int[][] array2D) {

		for (int i = 0; i < array2D.length; i++) {
			System.out.println();
			for (int j = 0; j < array2D[i].length; j++) {
				System.out.print(array2D[i][j] + " ");
			}
		}

	}
}