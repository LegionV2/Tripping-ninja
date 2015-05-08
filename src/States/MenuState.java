package States;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import example.Resources;

public class MenuState extends BasicGameState {

	Image startS;
	
	@Override
	public void init(GameContainer gc, StateBasedGame s) throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame s, Graphics g) throws SlickException {
		g.drawString("Hamster is not yet here!!", 200, 200);
		startS = Resources.getImage("StartScreen");
		startS.draw(0,0,800,600);
		
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame s, int delta) throws SlickException {
		if (gc.getInput().isKeyPressed(Input.KEY_ENTER)){
			s.enterState(States.GAME);
		}
		if (gc.getInput().isKeyPressed(Input.KEY_ESCAPE)){} //prevents state skipping
		
	}

	@Override
	public int getID() {
		return States.MENU;
	}

}
