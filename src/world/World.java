package world;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.newdawn.slick.Image;
import org.newdawn.slick.SpriteSheet;

import example.Resources;
import example.Window;

public class World {
	
	public static Image[][] solids;
	public static int WIDTH;
	public static int HEIGHT;
	
	public static void render(float xRender, float yRender){
		
		int offset = 2;
		int xStart = (int)(xRender/Tile.SIZE)-offset;
		int yStart = (int)(yRender/Tile.SIZE)-offset;
		int xEnd = (Window.WIDTH/Tile.SIZE)+xStart + (offset*2);
		int yEnd = (Window.HEIGHT/Tile.SIZE)+yStart + (offset*2);
		
		for (int x = xStart; x < xEnd; x++){
			for (int y = yStart; y < yEnd; y++){
				if(solidTile(x,y)){
					solids[x][y].draw(x * Tile.SIZE, y * Tile.SIZE, Tile.SIZE, Tile.SIZE);
				}
			}
		}
	}

	public static void load(String path) throws Exception{
		
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader(path));
		JSONObject jObj = (JSONObject) obj;
		
		JSONArray layers = (JSONArray) jObj.get("layers");
		int amount = layers.size();
		
		for (int i = 0; i < amount; i++){
			
			JSONObject layer = (JSONObject) layers.get(i);
			String type = (String) layer.get("name");
			
			if (type.equals("solids")) {
				WIDTH = (int)((long)layer.get("width"));
				HEIGHT = (int)((long)layer.get("height"));
				solids =parse((JSONArray)layer.get("data"));
			}else if (type.equals("spawns")) {
				//Spawner code here!
			}//if
		}//for
	}//load
	
	private static Image[][] parse(JSONArray arr) {
		
		Image[][] layer = new Image[WIDTH][HEIGHT];
		int index;
		
		for (int x = 0; x < WIDTH; x++){
			for (int y = 0; y < HEIGHT; y++){
				index = (int)((long)arr.get((y*WIDTH)+x));
				layer[x][y]=getSpriteImage(index);
			}	
		}
		return layer;
	}
	
	private static Image getSpriteImage(int index){
		
		if (index == 0) return null;
		index -= 1;
		
		SpriteSheet sheet = Resources.getSprite("tileset");
		int vertical = sheet.getVerticalCount();
		int horizontal = sheet.getHorizontalCount();
		
		int y = (index / vertical);
		int x = (index % horizontal);
		
		return sheet.getSubImage(x, y);
			
	}//getSpriteImage
	
	public static boolean inBounds(int x, int y){
		return (x >= 0 && y >= 0 && x < WIDTH && y < HEIGHT);
	}
	
	public static boolean solidTile(int x, int y) {
		return (inBounds(x,y) && solids[x][y] !=null);
	}
	
}
