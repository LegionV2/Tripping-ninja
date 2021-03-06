package example;

import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.SpriteSheet;

import world.Tile;

public class Resources {
	
	private static Map<String, Image> images;
	private static Map<String, SpriteSheet> sprites;
	private static Map<String, Sound> sounds;

	public Resources() {
		
		images = new HashMap<String, Image>();
		sprites = new HashMap<String, SpriteSheet>();
		sounds = new HashMap<String, Sound>();
		
		
		try {
			images.put("SpriteLr", loadImage("res/spriteLr.png"));
			images.put("SpriteRr", loadImage("res/spriteRr.png"));
			images.put("PH", loadImage("res/mobsteRr.png"));
			sprites.put("tileset", loadSprite("res/tileset.png",Tile.SMALL_SIZE, Tile.SMALL_SIZE));
			images.put("StartScreen", loadImage("res/hamster-1761.jpg"));
			images.put("Victory", loadImage("res/Endscreen.jpg"));
			images.put("defeat", loadImage("res/deadscreen.jpeg"));

		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Image loadImage(String path) throws SlickException{ //function for loading images.
		return new Image(path,false,Image.FILTER_NEAREST);
	}
	
	public static SpriteSheet loadSprite(String path, int tw, int th) throws SlickException{
		return new SpriteSheet(loadImage(path),tw,th);
	}
	
	
	public static SpriteSheet getSprite(String getter){
		return sprites.get(getter);
	}
	
	public static Image getSpriteImage(String getter,int x, int y){
		return sprites.get(getter).getSubImage(x, y);
	}

	
	public static Image getImage(String getter){
		return images.get(getter);
	}
	
	public static Sound getSound(String getter){
		return sounds.get(getter);
	}
}
