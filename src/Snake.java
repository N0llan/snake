import java.awt.Component;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Vector;

import javax.swing.JPanel;

public class Snake{
	private double speed = 1; 															//MOVE BLOCKSIZE HERE
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
