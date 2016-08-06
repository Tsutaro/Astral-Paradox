package engine.entities;

import engine.GUI.Screen;
import engine.GUI.Sprite;
import engine.level.Level;

public class Entity {
	public int x, y;
	protected Sprite sprite;
	protected boolean removed = false;
	protected Level level;
	
	public Entity(Level level){
		this.level = level;
	}
	
	protected boolean removed(){
		return removed;
	}
	
	protected void tick(){
	}
	
	protected void render(Screen screen){
	}
}
