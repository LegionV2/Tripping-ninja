package example;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

public class Hamster extends Entity{
	
	private float hSpeed = 0.3f;

	@Override
	public void init() {
		x = 200;
		y = 600;
		width = 31*2;
		height = 32*2;
		image = Resources.getImage("SpriteL");
		
	}

	@Override
	public void update(GameContainer gc, int delta) {
		
		Input input = gc.getInput();
		
		if (input.isKeyDown(Input.KEY_W)){
			
			y -= hSpeed*delta;
		}
		
		if (input.isKeyDown(Input.KEY_S)){
			
			y += hSpeed*delta;
		}

		if (input.isKeyDown(Input.KEY_A)){
	
			x -= hSpeed*delta;
		}

		if (input.isKeyDown(Input.KEY_D)){
	
			x += hSpeed*delta;
		}
		
		if (testLeft()) x += hSpeed*delta;
		if (testRight()) x -= hSpeed*delta;
		if (testUp()) y -= hSpeed*delta;
		if (testDown()) y -= hSpeed*delta;
	}
	
	

}
