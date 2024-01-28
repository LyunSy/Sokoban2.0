package entity;

public class Box extends Movable{
	
	private boolean goaled;

	public Box(int x, int y) {
		super(x, y);
		this.goaled = false;

	}
	
	public boolean getGoaled() {
		return this.goaled;
	}
	
	public void setGoaled(boolean goaled) {
		this.goaled = goaled;
	}

}
