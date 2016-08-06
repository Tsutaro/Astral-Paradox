package engine.GUI;

import engine.tiles.Tile;

public class Screen {
	public int width, height;
	public int[] pixels;
	
	private int xOffset, yOffset;
	
	public Screen(int width, int height){
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
	}
	
	public void clear(){
		for(int i = 0; i< pixels.length; i++){
			pixels[i] = 0;
		}
	}
	
	public void renderTile(int xp, int yp, Tile tile){
		xp -= xOffset;
		yp -= yOffset;
		for(int y = 0; y < tile.sprite.size; y++){
			int ya = y + yp;
			for(int x = 0; x < tile.sprite.size; x++){
				int xa = x + xp;
				if(xa < -tile.sprite.size || xa >= width || ya < 0 || ya >= height) break;
				if(xa < 0 ) xa = 0;
				pixels[xa + ya * width] = tile.sprite.pixels[x + y * tile.sprite.size];
			}
		}
	}
	
	public void renderPlayer(int xp, int yp, Sprite sprite){
		xp -= xOffset;
		yp -= yOffset;
		for(int y = 0; y < sprite.size; y++){
			int ya = y + yp;
			for(int x = 0; x < sprite.size; x++){
				int xa = x + xp;
				if(xa < -sprite.size || xa >= width || ya < 0 || ya >= height) break;
				if(xa < 0 ) xa = 0;
				int color = sprite.pixels[x + y * sprite.size];
				if(color != 0xff00ff){
					pixels[xa + ya * width] = color;
				}
			}
		}
	}
	
	public void setOffset(int x, int y){
		this.xOffset = x;
		this.yOffset = y;
	}
}
