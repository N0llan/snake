import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SnakeBodypart{
	private int x, y;
	private int dir;
	private BufferedImage bufferedImage;
	private String imgSrc;
	
	
	public SnakeBodypart(int x, int y, int dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;	
	}
	
	public BufferedImage getBufferedImage() {
		return bufferedImage;
	}

	public void loadImg() {
		try {
			setBufferedImage(ImageIO.read(new File(getImgSrc())));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public void setBufferedImage(BufferedImage bufferedImage) {
		this.bufferedImage = bufferedImage;
	}



	public String getImgSrc() {
		return imgSrc;
	}



	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
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
