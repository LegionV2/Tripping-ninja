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

public class MenuState extends BasicGameState {

	Image startS;
	
	@Override
	public void init(GameContainer gc, StateBasedGame s) throws SlickException {
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame s, Graphics g) throws SlickException {
		g.drawString("Hamster is not yet here!!", 200, 200);
		startS = Resources.getImage("StartScreen");
		startS.draw(0,0,800,600);
		g.setColor(Color.black);
		g.drawString("Game Made by: Rasmus k. Olesen", 450, 560);
		g.drawString("Kristoffer Piper, Patrick S.W.A", 450, 580);
		g.setColor(Color.white);
		
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame s, int delta) throws SlickException {
		if (gc.getInput().isKeyPressed(Input.KEY_ENTER)){
			GameState.points = 5000;
			GameState.lives = 5;
			s.enterState(States.GAME);
		}
		if (gc.getInput().isKeyPressed(Input.KEY_ESCAPE)){
			
			System.exit(1);
		} //prevents state skipping
		
	}

	@Override
	public int getID() {
		return States.MENU;
	}

}
