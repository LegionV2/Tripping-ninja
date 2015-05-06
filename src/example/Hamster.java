package example;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Hamster extends Entity{

	@Override
	public void init() {
		x = 1900;
		y = 1900;
		width = 32;
		height = 32;
		image = Resource.getImage("spriteL")
	}

	@Override
	public void update(GameContainer gc, int delta) {
		// TODO Auto-generated method stub
		
	}

	

}
