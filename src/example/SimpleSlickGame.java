package example;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;

public class SimpleSlickGame extends BasicGame
{
	float x = 200.0f;
	float y = 200.0f;
	float speed = 0.2f;
	float gravity;
	Image image;
	int edgeX = 720;
	int edgeY = 640;
	boolean isGrounded;
	
	private ArrayList<Entity>entities;
	
	
	public SimpleSlickGame(String gamename)
	{
		super(gamename);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {

		entities = new ArrayList<Entity>();
		
		entities.add(new Hamster());
		
		image = new Image ("spriteL.png");
		
	}

	@Override
	public void update(GameContainer gc, int i) throws SlickException {
		
		
		
		Input input = gc.getInput();
		
		//move right
		if (input.isKeyDown(Input.KEY_RIGHT)){
			image = new Image ("spriteR.png");
			if (x>edgeX+32){
				x = -31;
			}
			else{
				x += speed*i;
			}
		}
		
		//move left
		if (input.isKeyDown(Input.KEY_LEFT)){
			image = new Image ("spriteL.png");
			if (x<-32){
				x = edgeX+31;
			}
			else{
				x -= speed*i;
			}
		}
		
		if (isGrounded == true){
			gravity = 0.0f;
		}
		
		//move up
		if (input.isKeyPressed(Input.KEY_UP) && gravity == 0){
			isGrounded = false;
			gravity = -50.0f;
			

	}
		if (isGrounded == false){
		gravity += 0.1f;
		y += gravity*i/50;
		}
		
		//move down
		if (input.isKeyDown(Input.KEY_DOWN)){
			y +=1;
		}
			
		
		if (y>=edgeY-32){
				y = edgeY-32;
				isGrounded = true;
			}
			
			if (x<300 && x> 200 && y < edgeY-100 && y> edgeY - 101 && gravity > 0){
				isGrounded = true;
			}
			
		//}
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		int amount = entities.size();

		for (int n = 0; n < amount; n++){
			entities.get(n).render(gc,g);
		}
		
		g.drawImage (image, x, y);
	}

	public static void main(String[] args)
	{
		
		int edgeX = 720;
		int edgeY = 640;
		try
		{
			
			AppGameContainer appgc;
			appgc = new AppGameContainer(new SimpleSlickGame("Simple Slick Game"));
			appgc.setDisplayMode(edgeX, edgeY, false);
			appgc.start();
		}
		catch (SlickException ex)
		{
			Logger.getLogger(SimpleSlickGame.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}