package example;

import org.newdawn.slick.GameContainer;


public class Spider extends Entity {
	
	float xspawn = x;
	float yspawn = y;
	float movement;
	float midPosition;
	boolean upwards = true;
	boolean downwards = false;

	@Override
	public void init() {
		x = xspawn;
		y = yspawn;
		midPosition = y/2;
		movement = 0.3f;
		width = 40;
		height = 40;
		image = Resources.getImage("PH");
		
	}

	@Override
	public void update(GameContainer gc, int delta) {
		
		y += movement*delta;
		
		if (testDown()) movement *= -1;
		if (testUp()) movement *= -1;
	}

}
