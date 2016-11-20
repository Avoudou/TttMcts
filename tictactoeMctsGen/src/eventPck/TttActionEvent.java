package eventPck;

import tictactoeMain.TttGame;
import abstractDefinitions.AbstractAction;

public class TttActionEvent extends AbstractAction<TttGame> implements TttEvent {

	private int targetX;
	private int targetY;

	public TttActionEvent(int targetX, int targetY) {
		super();
		this.targetX = targetX;
		this.targetY = targetY;
	}
	
	public int getTargetY() {
		return targetY;
	}
	public int getTargetX() {
		return targetX;
	}

	@Override
	public String toString() {
		return "TttActionEvent [targetX=" + targetX + ", targetY=" + targetY + "]";
	}

}
