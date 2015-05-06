package example;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import world.World;
import States.*; // Imports everything from States class

public class SimpleSlickGame extends StateBasedGame
{
	float x = 200.0f;
	float y = 200.0f;
	float speed = 0.2f;
	
	public SimpleSlickGame(String gamename)
	{
		super(gamename);
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

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		
		new Resources();
		
		try {
			World.load("resources/maps/World.json");
		} catch (Exception e) {
			System.err.println("Map does not exist!");
			System.exit(0);
		}
		
		this.addState(new MenuState());
		this.addState(new GameState());
		this.addState(new EndState());
		
	}
}