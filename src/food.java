import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Food {
	private int xLoc, yLoc, blkSize;
	private BufferedImage bufferedImage;
	private String imgSrc = "img/apple.png";
	
	public Food(int xLoc, int yLoc, int blkSize) {
		this.blkSize = blkSize;
		this.xLoc = xLoc;
		this.yLoc = yLoc;
		try {
			bufferedImage = ImageIO.read(new File(imgSrc));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public BufferedImage getBufferedImage() {
		return bufferedImage;
	}

	public void setBufferedImage(BufferedImage bufferedImage) {
		this.bufferedImage = bufferedImage;
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
