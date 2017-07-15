import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.Stack;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.xml.transform.OutputKeys;

public class frame extends JPanel{
	private int width = 800 , height= 800;	//Height and Width of window.
	private JFrame frame;		
	private int delay = 0;					//Delay for repeating task
	private int blkSize = 20;				//Size of the snakeblock	
	private int dir; 						//The direction of the snake
	private boolean dirChanged = true;		//Boolean for changed direction to prevent 180 spin.
	private int speed = 100;				//Milliseconds for repeating task
	private Snake snake;
	
	public frame(){
		//Rita upp fönster
		frame = new JFrame("SNAKE");
		//frame.setBackground(Color.white);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(width, height));
		frame.add(this);
		this.setBackground(Color.WHITE);	
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);
		init();
		addListener();
		
		run();
	}
	
	private void init() {
		dir = direction.NER.getValue();
	}
	
	private void run() {
		snake = new Snake(randNumb(), randNumb(), dir);
		
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				repaint();
			}
		};
		Timer timer = new Timer(true);
		timer.scheduleAtFixedRate(timerTask, 0, 1000);
	}
	
	public void paint(Graphics g) {
		super.paintComponent(g);
		move(snake.getSnake().getLast());
		for (SnakeBodypart snakeBodypart : snake.getSnake()) {
			g.fillRect(snakeBodypart.getX(), snakeBodypart.getY(), blkSize, blkSize);
		}
		dirChanged = true;
		
	}
	
	public void move(SnakeBodypart snakeBodypart) {
		if (snake.getSnake().getFirst().getDir() == direction.UPP.getValue()) {
			snakeBodypart.setY(snake.getSnake().getFirst().getY() - blkSize);
			snakeBodypart.setX(snake.getSnake().getFirst().getX());
			if (snakeBodypart.getY() < 0) {
				snakeBodypart.setY(height);
			}	
		} else if (snake.getSnake().getFirst().getDir() == direction.NER.getValue()){
			snakeBodypart.setY(snake.getSnake().getFirst().getY() + blkSize);
			snakeBodypart.setX(snake.getSnake().getFirst().getX());
			if (snakeBodypart.getY() > height) {
				snakeBodypart.setY(0);
			}	
			
		} else if (snake.getSnake().getFirst().getDir() == direction.VÄNSTER.getValue()){
			snakeBodypart.setX(snake.getSnake().getFirst().getX() - blkSize);
			snakeBodypart.setY(snake.getSnake().getFirst().getY());
			if (snakeBodypart.getX() < 0) {
				snakeBodypart.setX(height);
			}	
			
		} else if (snake.getSnake().getFirst().getDir() == direction.HÖGER.getValue()){
			snakeBodypart.setX(snake.getSnake().getFirst().getX() + blkSize);
			snakeBodypart.setY(snake.getSnake().getFirst().getY());
			if (snakeBodypart.getX() > height) {
				snakeBodypart.setX(0);
			}		
		}
		snakeBodypart.setDir(snake.getSnake().getFirst().getDir());
		snake.getSnake().addFirst(snake.getSnake().pollLast());
	}
	
	public void addListener() {
		frame.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				int id = e.getKeyCode();
				if (dirChanged) {
					rotateSake(snake.getSnake().getFirst(), id);
				}	
				dirChanged = false;
				
			}
		});
	}
	
	public void rotateSake(SnakeBodypart snakeBodypart, int id) {
		
		if (id == KeyEvent.VK_UP) {
			if (snakeBodypart.getDir() != direction.NER.getValue()) {
				snakeBodypart.setDir(direction.UPP.getValue());
			}	
		} else if (id == KeyEvent.VK_DOWN) {
			if (snakeBodypart.getDir() != direction.UPP.getValue()) {
				snakeBodypart.setDir(direction.NER.getValue());
			}	
		} else if (id == KeyEvent.VK_LEFT) {
			if (snakeBodypart.getDir() != direction.HÖGER.getValue()) {
				snakeBodypart.setDir(direction.VÄNSTER.getValue());
			}	
		} else if (id == KeyEvent.VK_RIGHT) {
			if (snakeBodypart.getDir() != direction.VÄNSTER.getValue()) {
				snakeBodypart.setDir(direction.HÖGER.getValue());
			}	
		} else if (id== KeyEvent.VK_SPACE) {
			snake.increaseSnake(snakeBodypart.getDir(), blkSize);
		}	
		
//		if (snakeBodypart.getChild() != null) {
//			snakeStack.push(snakeBodypart.getChild());
//		}
	}
	
	public int randNumb() {
		boolean numberOK = false;
		int temp = 0;
		while (!numberOK) {
			temp = new Random().nextInt(width-0) + 0;
			numberOK = temp % 20 == 0;
		}
		if (numberOK) {
			return temp;
		}
		return 0;
	}
}
