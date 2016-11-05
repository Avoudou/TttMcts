package eventPck;

public class TttActionEvent extends TttEvent {

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

}
