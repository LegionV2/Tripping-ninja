package example;

import org.newdawn.slick.GameContainer;


public class Spider extends Entity {
	
	int xspawn;
	int yspawn;

	@Override
	public void init() {
		x = xspawn;
		y = yspawn;
		width = 108;
		height = 133;
		image = Resources.getImage("PH");
		
	}

	@Override
	public void update(GameContainer gc, int delta) {
		
		
	}

}
