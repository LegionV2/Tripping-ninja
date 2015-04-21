package example;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class SimpleSlickGame extends BasicGame
{
	float x = 200.0f;
	float y = 200.0f;
	float speed = 0.2f;
	Image image;
	int edgeX = 640;
	int edgeY = 480;
	boolean isGrounded;
	
	public SimpleSlickGame(String gamename)
	{
		super(gamename);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {

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
		
		
		//move up
		if (input.isKeyPressed(Input.KEY_UP) && isGrounded == true){
			isGrounded = false;
			if (y<= 0)
				y = 0;
			else{
				for (int spood = 0; spood < 3; spood++){
				if (spood == 0){
					y -= speed*400*i;
				}
				if (spood == 1){
					y -= speed*200*i;
				}
				if (spood == 2){
					y -= speed*100*i;
				}
			}				
		}

	}
		
		//move down
		//if (input.isKeyDown(Input.KEY_DOWN)){
			if (y>=edgeY-32){
				y = edgeY-32;
				isGrounded = true;
			}
			else {
				y += speed*i;
			}
		}
	

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		g.drawImage (image, x, y);
	}

	public static void main(String[] args)
	{
		
		int edgeX = 640;
		int edgeY = 480;
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