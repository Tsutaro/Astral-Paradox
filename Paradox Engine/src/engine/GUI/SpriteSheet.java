package engine.GUI;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
	public int size;
	public String path;
	public int[] pixels;
	
	public static SpriteSheet sheet = new SpriteSheet(256, "/spritesheets/spritesheet.png");
	
	public SpriteSheet(int size, String path){
		this.path = path;
		this.size = size;
		pixels = new int[size * size];
		load();
	}
	
	public void load(){
		try {
			BufferedImage img = ImageIO.read(SpriteSheet.class.getResource(path));
			int w = img.getWidth();
			int h = img.getHeight();
			img.getRGB(0, 0, w, h, pixels, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
