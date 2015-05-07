package example;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

import example.Entity;
import example.Resources;

public class Hamster extends Entity{
	
	private float hSpeed = 0.3f;

	@Override
	public void init() {
		x = 400;
		y = 750;
		width = 31;
		height = 32;
		image = Resources.getImage("SpriteLr");
		
	}

	@Override
	public void update(GameContainer gc, int delta) {
		
		Input input = gc.getInput();
		
		if (input.isKeyDown(Input.KEY_W)){
			
			y -= hSpeed*delta;
		}else
		
		if (input.isKeyDown(Input.KEY_S)){
			
			y += hSpeed*delta;
		}

		if (input.isKeyDown(Input.KEY_A)){
	
			x -= hSpeed*delta;
		} else

		if (input.isKeyDown(Input.KEY_D)){
	
			x += hSpeed*delta;
		}
		
		if (testLeft()) x += hSpeed*delta;
		if (testRight()) x -= hSpeed*delta;
		if (testUp()) y += hSpeed*delta;
		if (testDown()) y -= hSpeed*delta;
	}
	
	

}
