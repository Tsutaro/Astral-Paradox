package engine.entities;

import engine.GUI.Screen;
import engine.GUI.Sprite;
import engine.input.Controls;
import engine.level.Level;

public class Player extends Mob{
	private Controls controls;
	
	public Player(Controls controls, Level level){
		super(level);
		this.controls = controls;
	}
	
	public Player(int x, int y, Controls controls, Level level){
		super(level);
		this.x = x;
		this.y = y;
		this.controls = controls;
	}
	
	public void tick(){
		int xa = 0, ya = 0;
		if(controls.key.up) ya--;
		if(controls.key.down) ya++;
		if(controls.key.left) xa--;
		if(controls.key.right) xa++;
		
		if(xa != 0 || ya != 0){
			move(xa, 0);
			move(0, ya);
			walking = true;
		}else{
			walking = false;
		}
	}
	
	public void render(Screen screen){
		sprite = Sprite.player;
		screen.renderPlayer(x, y, sprite);
	}
}
