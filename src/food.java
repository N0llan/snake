
public class Food {
	private int xLoc, yLoc, blkSize;
	
	public Food(int xLoc, int yLoc, int blkSize) {
		this.blkSize = blkSize;
		this.xLoc = xLoc;
		this.yLoc = yLoc;
	}

	public int getxLoc() {
		return xLoc;
	}

	public void setxLoc(int xLoc) {
		this.xLoc = xLoc;
	}

	public int getyLoc() {
		return yLoc;
	}

	public void setyLoc(int yLoc) {
		this.yLoc = yLoc;
	}

	public int getBlkSize() {
		return blkSize;
	}

	public void setBlkSize(int blkSize) {
		this.blkSize = blkSize;
	}
	
	
}
