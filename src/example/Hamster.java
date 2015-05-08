package example;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

import example.Entity;
import example.Resources;

public class Hamster extends Entity{
	
	private float hSpeed = 10.0f;
	float gravity;
	int hSpawnX;
	int hSpawnY;
	

	@Override
	public void init() {
		x = hSpawnX;
		y = hSpawnY;
		width = 31;
		height = 32;
		image = Resources.getImage("SpriteRr");
		
	}

	@Override
	public void update(GameContainer gc, int delta) {
		
		Input input = gc.getInput();
		
//////////////////////////////////////////////////////movement///////////////////////////////////////////////////////////////
		if (input.isKeyDown(Input.KEY_A)){
			image = Resources.getImage("SpriteLr");
			x -= hSpeed*delta;
		} else

		if (input.isKeyDown(Input.KEY_D)){
			image = Resources.getImage("SpriteRr");
			x += hSpeed*delta;
		}
		
		if (input.isKeyDown(Input.KEY_W)){
			y -= hSpeed*delta;
		}else if (input.isKeyDown(Input.KEY_S)){
			y += hSpeed*delta;
		
		/*if (isGrounded == true){
			gravity = 0.0f;*/
		}
		
		/*if (input.isKeyPressed(Input.KEY_W) && isGrounded == true){//So you can't jump in the air
			gravity = -7.5f;
			isGrounded = false;

		}*/
		
		/*if (isGrounded == false){ //Basic gravity
			gravity += 0.2f;
			y += gravity;
		}*/
		
		/*if (gravity >= 7.5f){ // terminal velocity
			gravity = 7.5f;
		}*/
/////////////////////////////////////////////////Collision//////////////////////////////////////////////////////
		if (testLeft()) x += hSpeed*delta;
		if (testRight()) x -= hSpeed*delta;
		if (testUp() == true){
			//gravity = 0;     //Stops hamster when hitting something above him
			y += hSpeed*delta;
		}
		//While making ground collision detection also creates gravity when no collision is detected
		if (testDown() == false){
			isGrounded = false;
		}
		else if (testDown() == true){
			gravity = hSpeed*delta;
			//isGrounded = true;
		} 
		
	}	

}
