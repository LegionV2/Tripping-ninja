package States;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class ScoreState extends BasicGameState {


	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		// TODO Auto-generated method stub
		
	}
	
	public void render(GameContainer gc, StateBasedGame s, Graphics g) throws SlickException {
		g.drawString("Hamster came home!", 200, 200);
		g.drawString("Your score was: ", 200, 400);
		
	}
	
	public void update(GameContainer gc, StateBasedGame s, int delta) throws SlickException {
		if (gc.getInput().isKeyPressed(Input.KEY_ENTER)){
			s.enterState(States.MENU);
		}
		if (gc.getInput().isKeyPressed(Input.KEY_ESCAPE)){} //prevents state skipping
		
	}
	
	public int getID() {
		// TODO Auto-generated method stub
		return States.SCORE;
	}

	
}
