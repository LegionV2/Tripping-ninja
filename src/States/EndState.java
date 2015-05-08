package States;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import example.Resources;
import example.Window;

public class EndState extends BasicGameState {
	
	Image defeat;
	
	@Override
	public void init(GameContainer gc, StateBasedGame s) throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame s, Graphics g) throws SlickException {
		
		defeat = Resources.getImage("defeat");
		defeat.draw(0,0,Window.WIDTH,Window.HEIGHT);
		g.setColor(Color.black);
		g.drawString("Press ENTER to go to main menu.", 130, 150);
		g.setColor(Color.white);
		
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame s, int delta) throws SlickException {
		if (gc.getInput().isKeyPressed(Input.KEY_ENTER)){
			s.enterState(States.MENU);
		}
		if (gc.getInput().isKeyPressed(Input.KEY_ESCAPE)){} //prevents state skipping
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return States.END;
	}

}
