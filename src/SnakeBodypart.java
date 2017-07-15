import javax.swing.JPanel;

public class SnakeBodypart{
	private int x, y;
	private int dir;
	
	
	public SnakeBodypart(int x, int y, int dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	
	}
	

	public int getDir() {
		return dir;
	}

	public void setDir(int dir) {
		this.dir = dir;
	}

	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	
}
