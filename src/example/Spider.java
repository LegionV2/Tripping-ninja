package example;

import org.newdawn.slick.GameContainer;


public class Spider extends Entity {
	
	float xspawn;
	float yspawn;
	float movement;
	float midPosition;
	boolean upwards = true;
	boolean downwards = false;

	@Override
	public void init() {
		x = xspawn;
		y = 750;
		midPosition = 750/2;
		movement = 0.3f;
		width = 108;
		height = 133;
		image = Resources.getImage("PH");
		
	}

	@Override
	public void update(GameContainer gc, int delta) {
		
		if (y < midPosition && upwards == true){
			downwards = true;
			upwards = false;
		}
		else if (y>midPosition + 550 && downwards == true){
			downwards = false;
			upwards = true;
		}
		if (upwards == true){
			y -= movement*delta;
		}
		if (downwards == true){
			y += movement*delta;
		}
	}

}
