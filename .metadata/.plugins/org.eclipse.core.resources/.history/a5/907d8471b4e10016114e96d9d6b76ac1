import java.awt.*;

public class Bullet {
	public static int speed = 150; // how fast the bullet moves
	private double x, y; //location
	private boolean up;
	
	public Bullet(double x, double y, boolean up){
		this.x = x;
		this.y = y;
		this.up = up;
		
	}
	
	public void update(double d){
		if (up == true){
			y-=d*speed;
		} else {
			y+=d*speed;
		}
	}
	
	public void draw(Graphics g){
		g.setColor(Color.BLUE);
		g.drawLine((int)x, (int)y - 1, (int)x, (int)y+1);
	}
	
	public double getX(){
		return x;
	}
	
	public double getY(){
		return y;
	}
	
	public boolean moving(){
		return up;
	}
}
