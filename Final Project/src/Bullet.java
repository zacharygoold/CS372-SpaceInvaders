import java.awt.*;
/**
 * This class Bullet represents the bullet for the aliens and ship alike. 
 * 
 * @author zgoold17
 *
 */
public class Bullet {
	public static int speed = 150; // how fast the bullet moves
	private double x, y; //location
	private boolean up;
	
	public Bullet(double x, double y, boolean up){
		this.x = x;
		this.y = y;
		this.up = up;
		
	}
	/**
	 * This updates the speed of the bullet
	 * @param d
	 */
	public void update(double d){
		if (up == true){
			y-=d*speed;
		} else {
			y+=d*speed;
		}
	}
	
	/**
	 * This draws a line that is orange to represent the bullet
	 * @param g
	 */
	public void draw(Graphics g){
		g.setColor(Color.orange);
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
