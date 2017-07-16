import java.util.LinkedList;

public class Snake{															//MOVE BLOCKSIZE HERE
	private LinkedList<SnakeBodypart>snake;
	
	
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
	
	public LinkedList<SnakeBodypart> getSnake() {
		return snake;
	}

	
}
