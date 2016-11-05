package tictactoeMain;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TttMainMethod {

	public static void main(String args[]) {

		TttGame tictacttoe = new TttGame();
		TttLogic tictacLogic = new TttLogic();

		JFrame window = new JFrame();

		window.setSize(100, 100);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		JPanel panel = new JPanel();
		CustomKeyListener listener = new CustomKeyListener(tictacttoe,tictacLogic);
		panel.addKeyListener(listener);

		panel.setFocusable(true);
		window.add(panel);

		window.setVisible(true);
		print2DArray(tictacttoe.getBoard().getBoard());

	


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
