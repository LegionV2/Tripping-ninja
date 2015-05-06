package States;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import world.World;
import example.Entity;
import example.Resources;

public class GameState extends BasicGameState {

	private ArrayList<Entity>entities;
	
	@Override
	public void init(GameContainer gc, StateBasedGame s) throws SlickException {
		
		entities = new ArrayList<Entity>();
		
		entities.add(new Hamster());
		
		image = new Image ("spriteL.png");
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame s, Graphics g) throws SlickException {
		
		g.drawString("Hamster goes here!!", 200, 200);
		Resources.getSpriteImage("tileset",1,2).draw();
		
		g.translate(0, -550);
			World.render(0, 550);
		g.resetTransform();
		
		int amount = entities.size();

		for (int n = 0; n < amount; n++){
			entities.get(n).render(gc,g);
		}
	}

	@Override
	public void update(GameContainer gc, StateBasedGame s, int delta) throws SlickException {
		if (gc.getInput().isKeyPressed(Input.KEY_ENTER)){
			s.enterState(States.END);
			
			int amount = entities.size();

			for (int n = 0; n < amount; n++){
				entities.get(n).update(gc,i);
			}
		}
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return States.GAME;
	}

}
