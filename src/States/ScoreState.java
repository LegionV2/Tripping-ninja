package States;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class ScoreState {

	public void render(GameContainer gc, StateBasedGame s, Graphics g) throws SlickException {
		g.drawString("Hamster came home!", 200, 200);
		
		
	}
	
	public void update(GameContainer gc, StateBasedGame s, int delta) throws SlickException {
		if (gc.getInput().isKeyPressed(Input.KEY_ENTER)){
			s.enterState(States.MENU);
		}
		
	}
}