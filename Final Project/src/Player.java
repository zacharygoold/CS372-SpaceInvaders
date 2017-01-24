import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Vector;
/**
 * The Player models the ship that the player controls
 * Here I make boundries and only allow the player to do what I want them to do
 * @author zgoold17
 *
 */
public class Player {
	private double x, maxX, y; //position of player and where the boundaries are
	public static double speed = 60, shots = 2; //how fast the player moves
	public static int width = 40, height = 30; //width and height of the player
	private int lives;
	private long lastShot = 0;
	/**
	 * Here is the constructor that sets the players x, y, and where it cant go (aka past the width of the screen)
	 * @param x
	 * @param y
	 * @param maxX
	 */
	public Player(double x, double y, double maxX){ //constructor
		this.x = x;
		this.y = y;
		this.maxX = maxX;
		lives = 4;
	}
	
	/**
	 * Movement functions that move the ship at the speed desired right, or left (+= || -+)
	 * Also stops it from going to far either way
	 * @param d
	 */
	public void moveRight(double d){
		x += d*speed;
		if(x > maxX){ //stops it from going past on the right
			x = maxX;
		}
	}
	public void moveLeft(double d){
		x -= d*speed;
		if (x < 0){ //stops it from going past on the left
			x = 0;
		}
	}
	
	public void hit(){
		lives -= 1;
	}
	
	public int getLives(){
		return lives;
	}
	
	public void shoot(Vector<Bullet> bullets){
		double d = (System.nanoTime() - lastShot)*1E-9;
		if (d > 1/shots){
			bullets.add(new Bullet(x, y-height/2-2, true));
			lastShot = System.nanoTime();
		}
	}
	
	public boolean shot(Bullet b){
		Rectangle container = new Rectangle((int)x-width/2,(int)y-height/2, width, height);
		if (container.contains(new Point((int)b.getX(), (int)b.getY()))){
			return true;
		}
		return false;
	}
	
	/**
	 * Draws a rectangle that is BLUE to represent the player
	 * @param g
	 */
	public void draw(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect((int)x-width/2, (int)y-height/2, width, height);
	}
	
	
}
