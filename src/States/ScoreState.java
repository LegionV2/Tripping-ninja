package States;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import example.Resources;
import example.Window;

public class ScoreState extends BasicGameState {

	Image victor;
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		// TODO Auto-generated method stub
		
	}
	
	public void render(GameContainer gc, StateBasedGame s, Graphics g) throws SlickException {
		
		victor = Resources.getImage("Victory");
		victor.draw(0,0,Window.WIDTH,Window.HEIGHT);
		g.drawString("The hamster came home!", 300, 10);
		g.drawString("Your score was: "+ GameState.points, 300, 30);
		g.drawString("You had " + GameState.lives + " lives left.", 300, 50);
		g.drawString("Press ENTER to return to the main menu.", 245, 70);

		g.drawString("Special thanks to for pictures and sprits.", 205, 480);
		g.drawString("d13yacurqjgara.cloudfront.net", 205, 500);
		g.drawString("http://animals.desktopnexus.com/wallpaper/940258/", 200, 520);
		g.drawString("Hamster domestique - Wamiz", 200, 540);
		g.drawString("https://www.pinterest.com/pin/46091596158326998/", 200, 560);
		g.drawString("bunnynibble15", 200, 580);
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
