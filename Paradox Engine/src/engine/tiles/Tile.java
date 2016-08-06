package engine.tiles;

import engine.GUI.Screen;
import engine.GUI.Sprite;

public class Tile {
	
	public Sprite sprite;
	private boolean solid;
	
	public static Tile grassTile = new Tile(Sprite.grass, false);
	public static Tile flowerTile = new Tile(Sprite.flower, true);
	public static Tile voidTile = new Tile(Sprite.voidSprite, false);
	
	public Tile(Sprite sprite, boolean solid){
		this.sprite = sprite;
		this.solid = solid;
	}
	
	public void render(int x, int y, Screen screen){
		screen.renderTile(x * 32, y * 32, this);
	}
	
	public boolean solid(){
		return solid;
	}
}
