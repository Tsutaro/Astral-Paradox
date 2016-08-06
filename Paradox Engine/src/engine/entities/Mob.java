package engine.entities;

import engine.GUI.Screen;
import engine.level.Level;

public class Mob extends Entity{
	
	protected int dir = 0, steps;
	protected boolean walking = false;
	
	public Mob(Level level){
		super(level);
	}
	
	protected void tick(){
		
	}
	
	protected void render(Screen screen){
		
	}
	
	protected void move(int xa, int ya){		
		if(xa != 0 && ya != 0){
			move(xa, 0);
			move(0, ya);
		}
		
		if(!collision(xa, ya)){
			y += ya;
			x += xa;
		}
		
		if(ya < 0) dir = 0;
		if(xa > 0) dir = 1;
		if(ya > 0) dir = 2;
		if(xa < 0) dir = 3;		
	}
	
	protected boolean collision(int xa, int ya){
		boolean solid = false;
		for(int c = 0; c < 4; c++){
			int xCollision = ((xa + x) + c % 2 * 20 + 5)/32;
			int yCollision = ((ya + y) + c / 2 * 17 + 13)/32;
			if(level.getTile(xCollision, yCollision).solid()) solid = true;
		}
		return solid;
	}
}
