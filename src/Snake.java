import java.util.LinkedList;

public class Snake{															//MOVE BLOCKSIZE HERE
	private LinkedList<SnakeBodypart>snake;
	private String imgSrcHead = "img/snakehead"; 
	private String imgSrcBody = "img/snakeBody";
	
	
	public Snake(int xPos, int yPos, int dir) {
		snake = new LinkedList<SnakeBodypart>();
		snake.add(new SnakeBodypart(xPos, yPos, dir));
	}
	
	public void increaseSnake(int dir, int blkSize) {
		if (dir == direction.UPP.getValue()) {
			SnakeBodypart newBodyPart = new SnakeBodypart(snake.getLast().getX(), snake.getLast().getY() + blkSize, dir);
			snake.add(newBodyPart);
		} else if (dir == direction.NER.getValue()) {
			SnakeBodypart newBodyPart = new SnakeBodypart(snake.getLast().getX(), snake.getLast().getY() - blkSize, dir);
			snake.add(newBodyPart);
		} else if (dir == direction.VÄNSTER.getValue()) {
			SnakeBodypart newBodyPart = new SnakeBodypart(snake.getLast().getX() + blkSize, snake.getLast().getY(), dir);
			snake.add(newBodyPart);
		} else if (dir == direction.HÖGER.getValue()) {
			SnakeBodypart newBodyPart = new SnakeBodypart(snake.getLast().getX() - blkSize, snake.getLast().getY(), dir);
			snake.add(newBodyPart);
		}
	}
	
	public void detImgSrc() {
		for (SnakeBodypart snakeBodypart : snake) {
			if (snakeBodypart.equals(snake.getFirst())) {
				if (snakeBodypart.getDir() == direction.UPP.getValue()) {
					snakeBodypart.setImgSrc(imgSrcHead+"UPP.png");
				} else if(snakeBodypart.getDir() == direction.NER.getValue()) {
					snakeBodypart.setImgSrc(imgSrcHead+"NER.png");
				} else if (snakeBodypart.getDir() == direction.VÄNSTER.getValue()) {
					snakeBodypart.setImgSrc(imgSrcHead+"VÄNSTER.png");
				} else if (snakeBodypart.getDir() == direction.HÖGER.getValue()) {
					snakeBodypart.setImgSrc(imgSrcHead+"HÖGER.png");
				}
			}	else {
				if (snakeBodypart.getDir() == direction.UPP.getValue() || snakeBodypart.getDir() == direction.NER.getValue()) {
					snakeBodypart.setImgSrc(imgSrcBody+"Vert.png");
				} else if (snakeBodypart.getDir() == direction.HÖGER.getValue() || snakeBodypart.getDir() == direction.VÄNSTER.getValue()) {
					snakeBodypart.setImgSrc(imgSrcBody+"Hori.png");
				}
			}
			snakeBodypart.loadImg();
		}
		
	}
	
	public LinkedList<SnakeBodypart> getSnake() {
		return snake;
	}

	
}
