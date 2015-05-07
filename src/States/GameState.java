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
import example.Hamster;
import example.Resources;


public class GameState extends BasicGameState {

	private ArrayList <Entity> entities;
	public float a;
	public float b = -550;
	
	@Override
	public void init(GameContainer gc, StateBasedGame s) throws SlickException {
		
		entities = new ArrayList<Entity>();
		
		entities.add(new Hamster());
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame s, Graphics g) throws SlickException {
		
		
		
		g.drawString("Hamster goes here!!", 200, 200);
		

		g.translate(a, b);
		
			World.render(-a, -b);
		
		
		int hugeness = entities.size();
		for (int i = 0; i < hugeness; i++){
			entities.get(i).render(gc,g);
		}
		g.resetTransform();
	}

	@Override
	public void update(GameContainer gc, StateBasedGame s, int delta) throws SlickException {

		if (gc.getInput().isKeyPressed(Input.KEY_ENTER)){
			s.enterState(States.END);
			System.out.println("enter is entered");

			}

			a = 400-entities.get(0).x;
			b = 400-entities.get(0).y;
		int hugeness = entities.size();
		for (int i = 0; i < hugeness; i++){
			entities.get(i).update(gc,delta);

		}
		
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return States.GAME;
	}

}
