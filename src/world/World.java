package world;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.newdawn.slick.Image;
import org.newdawn.slick.SpriteSheet;

import example.Resources;

public class World {
	
	public static Image[][] solids;
	public static int WIDTH;
	public static int HEIGHT;

	public static void load(String path) throws Exception{
		
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader(path));
		JSONObject jObj = (JSONObject) obj;
		
		JSONArray layers = (JSONArray) jObj.get("Layers");
		int amount = layers.size();
		
		for (int i = 0; i<amount; i++){
			JSONObject layer = (JSONObject) layers.get(i);
			String type = (String) layer.get("name");
			
			if (type.equals("solids")) {
				solids =parse((JSONArray)layer.get("data"));
			}else if (type.equals("spawns")) {
				//Spawner code here!
			}//if
		}//for
	}//load
	
	private static Image[][] parse(JSONArray arr) {
		
		Image[][] layer = new Image[WIDTH][HEIGHT];
		int index;
		
		for (int y = 0; y < WIDTH; y++){
			for (int x = 0; x < HEIGHT; x++){
				index = (int)((long)arr.get((y*WIDTH)+x));
				layer[x][y]=getSpriteImage(index);
			}	
		}
		return layer;
	}
	
	private static Image getSpriteImage(int index){
		if (index == 0){
			return null;
		}
		index -= 1;
		
		SpriteSheet sheet = Resources.getSprite("tileset");
		int vertical = sheet.getVerticalCount();
		int horizontal = sheet.getHorizontalCount();
		
		int y = (index / vertical);
		int x = (index % horizontal);
		
		return sheet.getSubImage(x, y);
			
	}//getSpriteImage
}
