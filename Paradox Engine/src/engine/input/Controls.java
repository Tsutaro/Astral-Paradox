package engine.input;

import engine.Engine;

public class Controls {
	public KeyBoard key;
	public Mouse mouse;
	
	public Controls(Engine engine){
		key = new KeyBoard();
		mouse = new Mouse();
		
		engine.addKeyListener(key);
		engine.addMouseListener(mouse);
		engine.addMouseMotionListener(mouse);
	}
	
	public void tick(){
		key.tick();
	}
}
