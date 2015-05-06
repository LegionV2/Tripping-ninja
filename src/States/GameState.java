package States;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import world.World;
import example.Resources;

public class GameState extends BasicGameState {

	@Override
	public void init(GameContainer gc, StateBasedGame s) throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame s, Graphics g) throws SlickException {
		
		g.drawString("Hamster goes here!!", 200, 200);
		Resources.getSpriteImage("tileset",1,2).draw();
		
		g.translate(0, -550);
			World.render(0, 550);
		g.resetTransform();
	}

	@Override
	public void update(GameContainer gc, StateBasedGame s, int delta) throws SlickException {
		if (gc.getInput().isKeyPressed(Input.KEY_ENTER)){
			s.enterState(States.END);
		}
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return States.GAME;
	}

}
