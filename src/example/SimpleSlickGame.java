package example;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class SimpleSlickGame extends BasicGame
{
	float x = 200.0f;
	float y = 200.0f;
	float speed = 0.2f;
	
	public SimpleSlickGame(String gamename)
	{
		super(gamename);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		
	}

	@Override
	public void update(GameContainer gc, int i) throws SlickException {
		Input input = gc.getInput();
		
		//move right
		if (input.isKeyDown(Input.KEY_RIGHT)){ 
			x += speed*i;
		}
		
		//move left
		if (input.isKeyDown(Input.KEY_LEFT)){
			x -= speed*i;
		}
		
		//move up
		if (input.isKeyDown(Input.KEY_UP)){
			y -= speed*i;
		}
		
		//move down
		if (input.isKeyDown(Input.KEY_DOWN)){
			y += speed*i;
		}
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		g.drawString("Hello World!", x, y);
	}

	public static void main(String[] args)
	{
		try
		{
			AppGameContainer appgc;
			appgc = new AppGameContainer(new SimpleSlickGame("Simple Slick Game"));
			appgc.setDisplayMode(640, 480, false);
			appgc.start();
		}
		catch (SlickException ex)
		{
			Logger.getLogger(SimpleSlickGame.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}