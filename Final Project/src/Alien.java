import java.awt.*;

/**
 * The Alien models the alien ships that move in a left to right pattern, shooting, and able to be shot
 * @author zgoold17
 *
 */
public class Alien {
	public static int width = 20, height = 20;
	public static double speedX = 40, speedY = 20, bulletSpeed = .0025; //how fast the alien moves
	private double x, y, maxX, maxY, dx, dy, bullet; //position, max position, and speed
	
	/**
	 * This is the constructor that stops aliens from going where they shouldn't and sets its x,y
	 * @param x
	 * @param y
	 * @param maxX
	 * @param left
	 */
	public Alien(double x, double y, double maxX, boolean left){
		this.x = x;
		this.y = y;
		this.maxX = maxX;
		
		if (left == true){
			dx = -speedX;
		} else{
			dx = speedX;
		}
		dy = speedY;
		bullet = bulletSpeed;
	}
	
	/**
	 * Updates the speed of the alien as it moves, checks to see if it hits a wall
	 * @param d
	 */
	public void update(double d){
		x+=dx*d;
		y+=dy*d;
		if(x > maxX || x < 0){
			wall();
		}
	}
	
	/**
	 * function to see if it hits the wall
	 */
	public void wall(){
		if (x > maxX){
			x = maxX;
		} 
		if (x < 0){
			x = 0;
		}

	}
	
	/**
	 * Draws a rectangle that is RED to represent the aliens
	 * @param g
	 */
	public void draw(Graphics g){
		g.setColor(Color.RED);
		g.fillRect((int)x-width/2, (int)y-height/2,  width, height);
	}
	
	
}
