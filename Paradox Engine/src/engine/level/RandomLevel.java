package engine.level;

import java.util.Random;

import java.util.Random;

public class RandomLevel extends Level{
	private static Random random = new Random();
	
	public RandomLevel(int width, int height) {
		super(width, height);
	}
	
	public void generateLevel(){
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++){
				pixels[x + y * width] = random.nextInt(2);
			}
		}
	}

}
