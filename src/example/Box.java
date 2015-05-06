package example;

public class Box {
	
	public float x; 
	public float y;
	public float width;
	public float height;
	
	public Box(){
		
	}
	
	public Box(float x, float y, float width, float height){
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
	}
	
	public float GetEndX(){
		return (x+width);
	}
	
	public float GetEndY(){
		return (y+height);
	}
	
	public float GetHalfWidth(){
		return (width/2);
	}
	
	public float GetHalfHeight(){
		return (height/2);
	}
	
	public float GetCenterX(){
		return (x+GetHalfWidth());
	}
	
	public float GetCenterY(){
		return (y+GetHalfHeight());
	}
	
	public boolean hitTest (Box b){
		return (b.GetEndX()>= x && b.GetEndY() >= y && GetEndX() >= b.x && GetEndY() >= b.y);
	}
}
