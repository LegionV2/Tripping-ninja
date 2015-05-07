package example;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import world.World;
import example.Box;

public abstract class Entity extends Box {
	
	public Image image;
	public Color color;
	
	public Entity(){
		init();
	}
	
	public abstract void init();
	
	public void render (GameContainer gc, Graphics g){
		
		if (image != null){
			image.draw(x,y,width,height,color);
		}
	}
	public abstract void update (GameContainer gc, int delta);
	
	public boolean testLeft(){
		return (World.hitTest(x,GetCenterY()));
	}
	
	public boolean testRight(){
		return (World.hitTest(GetEndX(),GetCenterY()));
	}
	public boolean testUp(){
		return (World.hitTest(y,GetCenterX()));
	}
	public boolean testDown(){
		return (World.hitTest(GetEndY(),GetCenterX()));
	}

}
