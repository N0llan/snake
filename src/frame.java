import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class frame extends JPanel{
	private int width = 400 , height= 400;	//Height and Width of window.
	private JFrame frame;		
	private int blkSize;					//Size of the snakeblock	
	private boolean dirChanged = true;		//Boolean for changed direction to prevent 180 spin.
	private int speed;						//Milliseconds for repeating task, in practice the speed of the snake
	private int speedModule;
	private Snake snake;
	private Food food;
	private JMenuBar mainMenuBar;
	private JMenuItem startGame;
	private JMenu menu, settings;
	
	
	public frame(){
		//Rita upp fönster
		init();
		frame = new JFrame("SNAKE");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setJMenuBar(mainMenuBar);
		changeWindowSize();
		
		addListener();

	}
	
	public void changeWindowSize(){
		this.setPreferredSize(new Dimension(width, height));
		frame.add(this);
		this.setBackground(Color.WHITE);	
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);
	}
	
	private void init() {
		speed = 100;
		speedModule = 3;
		blkSize = 20;
		createMenu();
		startGame.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				startGame();
				
			}
		});
		
		food = new Food(randNumb(width-blkSize, blkSize), randNumb(height-blkSize, blkSize), blkSize);
		snake = new Snake(randNumb(width-blkSize, blkSize), randNumb(height-blkSize, blkSize), randNumb(4, 1));	
	}
	
	private void createMenu(){
		menu = new JMenu("Arkiv");
		settings = new JMenu("Settings");
		mainMenuBar = new JMenuBar();
		mainMenuBar.add(menu);
		mainMenuBar.add(settings);
		
		startGame = new JMenuItem("Start");
		menu.add(startGame);
	}
	
	public void startGame(){
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while (true) {
					move(snake.getSnake().getLast());
					increaseSpeed();
					repaint();
					try {
						Thread.sleep(speed);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();
		
	}
	
	public void increaseSpeed() {
		if (snake.getSnake().size() % speedModule == 0) {
			speed *= 0.85;	
			speedModule += 3;

		}
	}

	public void paint(Graphics g) {
		super.paintComponent(g);
		snake.detImgSrc();
		g.setColor(Color.RED);
		g.drawImage(food.getBufferedImage(), food.getxLoc(), food.getyLoc(), food.getBlkSize(), food.getBlkSize(), null);
		g.setColor(Color.GREEN);
		for (SnakeBodypart snakeBodypart : snake.getSnake()) {
			g.drawImage(snakeBodypart.getBufferedImage(), snakeBodypart.getX(), snakeBodypart.getY(), blkSize, blkSize, null);
		}
		
		dirChanged = true;
		
	}
	
	public void move(SnakeBodypart snakeBodypart) {
		if (snake.getSnake().getFirst().getDir() == direction.UPP.getValue()) {
			snakeBodypart.setY(snake.getSnake().getFirst().getY() - blkSize);
			snakeBodypart.setX(snake.getSnake().getFirst().getX());
			if (snakeBodypart.getY() < 0) {
				snakeBodypart.setY(height-blkSize);
			}	
		} else if (snake.getSnake().getFirst().getDir() == direction.NER.getValue()){
			snakeBodypart.setY(snake.getSnake().getFirst().getY() + blkSize);
			snakeBodypart.setX(snake.getSnake().getFirst().getX());
			if (snakeBodypart.getY() >= height) {
				snakeBodypart.setY(0);
			}	
			
		} else if (snake.getSnake().getFirst().getDir() == direction.VÄNSTER.getValue()){
			snakeBodypart.setX(snake.getSnake().getFirst().getX() - blkSize);
			snakeBodypart.setY(snake.getSnake().getFirst().getY());
			if (snakeBodypart.getX() < 0) {
				snakeBodypart.setX(height - blkSize);
			}	
			
		} else if (snake.getSnake().getFirst().getDir() == direction.HÖGER.getValue()){
			snakeBodypart.setX(snake.getSnake().getFirst().getX() + blkSize);
			snakeBodypart.setY(snake.getSnake().getFirst().getY());
			if (snakeBodypart.getX() >= height) {
				snakeBodypart.setX(0);
			}		
		}
		snakeBodypart.setDir(snake.getSnake().getFirst().getDir());
		snake.getSnake().addFirst(snake.getSnake().pollLast());
		isSnakeDead();
		foodOutsideSnake();		
	}
	
	public void isSnakeDead(){
		for (SnakeBodypart sBodypart : snake.getSnake()) {
			if (snake.getSnake().getFirst() != sBodypart) {
				if (sBodypart.getX() == snake.getSnake().getFirst().getX() && sBodypart.getY() == snake.getSnake().getFirst().getY()) {
					System.out.println("DEAD");
					snake = new Snake(randNumb(width-blkSize, blkSize), randNumb(height-blkSize, blkSize), randNumb(4, 1));
					speedModule = 3;
					speed = 100;
				}
			}
		}
	}
	
	public void foodOutsideSnake(){
		if (snake.getSnake().getFirst().getX() == food.getxLoc() && snake.getSnake().getFirst().getY() == food.getyLoc()) {
			snake.increaseSnake(snake.getSnake().getLast().getDir(), blkSize);
			boolean foodOutsideSnake = false;
			while (!foodOutsideSnake){
				foodOutsideSnake = true;
				food = new Food(randNumb(width-blkSize, blkSize), randNumb(height-blkSize, blkSize), blkSize);
				for (SnakeBodypart sBodypart : snake.getSnake()) {
					if (food.getxLoc() == sBodypart.getX() && food.getyLoc() == sBodypart.getY()){
						foodOutsideSnake = false;
					}
				}
			}
		}
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
		} 
		
	}

	public int randNumb(int maxNumber, int module) {
		boolean numberOK = false;
		int temp = 0;
		while (!numberOK) {
			temp = new Random().nextInt(maxNumber) + 1;
			numberOK = temp % module == 0;
		}
		if (numberOK) {
			return temp;
		}
		return 0;
	}
}
