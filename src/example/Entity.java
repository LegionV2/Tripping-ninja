package example;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;

import world.World;
import example.Box;

public abstract class Entity extends Box {
	
	public Image image;
	public Color color;
	public boolean isGrounded = false;
	public boolean isFalling;
	public boolean isRising;
	
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
		return (World.hitTest(GetCenterX(),y));
	}
	public boolean testDown(){
		System.out.println (World.hitTest(GetCenterX(), GetEndY()));
			return (World.hitTest(GetCenterX(),GetEndY()));
			
	}

}
