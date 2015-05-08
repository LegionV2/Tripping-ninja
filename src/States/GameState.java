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
import example.Spider;



public class GameState extends BasicGameState {

	private ArrayList <Entity> entities;
	public float a;
	public float b = -550;
	int points;
	
	@Override
	public void init(GameContainer gc, StateBasedGame s) throws SlickException {
		
		entities = new ArrayList<Entity>();
		entities.add(new Hamster());
		entities.add(new Spider());
		entities.add(new Spider());
		entities.get(1).x = 300;
		entities.get(1).y = 750;
		entities.get(2).x = 600;
		entities.get(2).y = 750;
		
	}
	
	
	@Override
	public void render(GameContainer gc, StateBasedGame s, Graphics g) throws SlickException {
		
		
		

		g.translate(a, b);
		
			World.render(-a, -b);

			g.drawString("Lives : ", -a+50, -b+50);
			g.drawString("Points : " + points,-a+200, -b+50);
			
		
		
		int hugeness = entities.size();
		for (int i = 0; i < hugeness; i++){
			entities.get(i).render(gc,g);
			
		}
			if (entities.get(0).y>1367){
				entities.get(0).y =1044;
				entities.get(0).x =400;
				
			
				
			}
		
		
		g.resetTransform();
	}

	@Override
	public void update(GameContainer gc, StateBasedGame s, int delta) throws SlickException {

		if (gc.getInput().isKeyPressed(Input.KEY_ESCAPE)){
			s.enterState(States.GAME2);
			entities.get(0).x = 400;
			entities.get(0).y = 1044;

			}
		 if (entities.get(0).x >= 3160) {
			 s.enterState(States.SCORE);
			 entities.get(0).x = 400;
			 entities.get(0).y = 1044;
		 }

			a = 400-entities.get(0).x;
			b = 400-entities.get(0).y;
		
			int hugeness = entities.size();
			for (int i = 0; i < hugeness; i++){
				entities.get(i).update(gc,delta);
			}
			/*if (gc.getInput().isKeyPressed(Input.KEY_5)){
				points += 5;
			}*/
			
			if (b<-550){
				b=-550;
				}
			
				if (a>=-0){
					a=0;
				}
			if (a<=-2400){
						a=-2400;
				}
			
		}
		

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return States.GAME;
	}

}
