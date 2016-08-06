package engine;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import engine.GUI.Screen;
import engine.entities.Player;
import engine.input.Controls;
import engine.level.Level;
import engine.level.RandomLevel;

public class Engine extends Canvas implements Runnable{
	private static final long serialVersionUID = 1L;
	private int width, height, scale;
	private String name;
	private Dimension size;
	private JFrame frame;
	private Thread thread;
	private boolean running = false;
	
	private BufferedImage img;
	private int pixels[];

	private Controls controls;
	private Screen screen;
	private Level level;
	
	private Player player;
	
	public Engine(int width, int height, int scale, String name){
		this.width = width;
		this.height = height;
		this.scale = scale;
		this.name = name;
		size = new Dimension(width * scale, height * scale);
		frame = new JFrame(name);
		thread = new Thread(this);		
		init();
	}
	
	public void init(){
		setMinimumSize(size);
		setMaximumSize(size);
		setPreferredSize(size);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.add(this);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt)img.getRaster().getDataBuffer()).getData();
		
		
		controls = new Controls(this);
		screen = new Screen(width, height);
		level = new RandomLevel(64, 64);
		player = new Player(controls, level);
	}
	
	public synchronized void start(){
		running = true;
		thread.start();
	}
	
	public synchronized void stop(){
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void run(){
		requestFocus();
		while(running){
			tick();
			render();
		}
	}
	
	public void tick(){
		controls.tick();
		player.tick();
	}
	
	public void render(){
		BufferStrategy bs = getBufferStrategy();
		if(bs == null){
			createBufferStrategy(2);
			return;
		}
		
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = screen.pixels[i];
		}
		
		//clear the screen
		screen.clear();
		
		//Level Rendering
		int xMid = player.x - (screen.width/2) + 16;
		int yMid = player.y - (screen.height/2) + 16;
		level.render(xMid, yMid, screen);
		
		
		//player rendering
		player.render(screen);
		
		Graphics g = bs.getDrawGraphics();
		g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
		g.dispose();
		bs.show();
	}
	
	public static void main(String[] args){
		new Engine(640, 360, 2, "Paradox Engine pre-alpha v1").start();
	}
}
