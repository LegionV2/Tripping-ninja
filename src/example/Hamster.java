package example;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

import example.Entity;
import example.Resources;

public class Hamster extends Entity{
	
	private float hSpeed = 0.3f;
	float gravity;
	

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
		

		if (input.isKeyDown(Input.KEY_A)){
	
			x -= hSpeed*delta;
		} else

		if (input.isKeyDown(Input.KEY_D)){
	
			x += hSpeed*delta;
		}
		
		if (isGrounded == true){
			gravity = 0.0f;
		}
		
		if (input.isKeyPressed(Input.KEY_W) && isGrounded == true){
			gravity = -9.0f;
			isGrounded = false;
			isRising = true;

		}
		if (isGrounded == false){
			gravity += 0.3f;
			y += gravity;
		}

		
		if (testLeft()) x += hSpeed*delta;
		if (testRight()) x -= hSpeed*delta;
		if (testUp() == true){
			gravity = 0;
			y += hSpeed*delta;
		}
		if (testDown() == false){
			isGrounded = false;
		}
		else if (testDown() == true){
			gravity = hSpeed*delta;
			isGrounded = true;
		} 
		
	}	

}
