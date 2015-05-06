package example;

import org.newdawn.slick.GameContainer;

public class Hamster extends Entity{

	@Override
	public void init() {
		x = 1900;
		y = 1900;
		width = 32*2;
		height = 32*2;
		image = Resources.getImage("SpriteL");
		
	}

	@Override
	public void update(GameContainer gc, int delta) {
		// TODO Auto-generated method stub
		
	}
	
	

}
