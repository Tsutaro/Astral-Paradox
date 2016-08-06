package engine.GUI;

public class Sprite {
	public int size;
	public int x, y;
	public int pixels[];
	private SpriteSheet sheet;
	
	public static Sprite grass = new Sprite(0, 0, 32, SpriteSheet.sheet);
	public static Sprite flower = new Sprite(1, 0, 32, SpriteSheet.sheet);
	public static Sprite voidSprite = new Sprite(32, 0xff00ff);
	
	public static Sprite player = new Sprite(0, 7, 32, SpriteSheet.sheet);
	
	public Sprite(int x, int y, int size, SpriteSheet sheet){
		this.sheet = sheet;
		this.size = size;
		this.x = x * size;
		this.y = y * size;
		pixels = new int[size * size];
		load();
	}
	
	public Sprite(int size, int color){
		this.size = size;
		pixels = new int[size * size];
		setColor(color);
	}
	
	public void setColor(int color){
		for(int i = 0; i < size * size; i++){
			pixels[i] = color;
		}
	}
	
	public void load(){
		for(int y = 0; y < size; y++){
			for(int x = 0; x < size; x++){
				pixels[x + y * size] = sheet.pixels[(this.x + x) + (this.y + y) * sheet.size];
			}
		}
	}
}
