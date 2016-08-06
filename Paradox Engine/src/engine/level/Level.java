package engine.level;

import engine.GUI.Screen;
import engine.tiles.Tile;

public class Level {
	protected int width, height;
	protected int pixels[];
	
	public Level(int width, int height){
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
		generateLevel();
	}
	
	public Level(String path){
		loadLevel(path);
		generateLevel();
	}
	
	protected void loadLevel(String path){
		
	}
	
	protected void generateLevel(){
	}
	
	public void render(int xScroll, int yScroll, Screen screen){
		screen.setOffset(xScroll, yScroll);
		int x0 = (xScroll - 32) / 32;
		int x1 = (xScroll + screen.width + 32) / 32;
		int y0 = (yScroll - 32)/32;
		int y1 = (yScroll + screen.height + 32) /32;
		for(int y = y0; y < y1; y++){
			for(int x = x0; x < x1; x++){
				getTile(x, y).render(x, y, screen);
			}
		}
	}
	
	public Tile getTile(int x, int y){
		if(x < 0 || y < 0 || x >= width || y >= height) return Tile.voidTile;
		if(pixels[x + y * width] == 0) return Tile.grassTile;
		if(pixels[x + y * width] == 1) return Tile.flowerTile;
		return Tile.voidTile;
	}
}
