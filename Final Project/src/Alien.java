import java.awt.*;

public class Alien {
	public static int width = 20, height = 20;
	public static double speedX = 40, speedY = 20; //how fast the alien moves
	private double x, y, maxX, maxY, dx, dy; //position, max position, and speed
	
	public Alien(double x, double y, double maxX, boolean left){
		this.x = x;
		this.y = y;
		this.maxX = maxX;
		
		if (left == true){
			dx = -speedX;
		} else{
			dx = speedX;
			dy = speedY;
		}
	}
	
	public void update(double d){
		x+=dx*d;
		y+=dy*d;
	}
	

	
	
	public void draw(Graphics g){
		g.setColor(Color.RED);
		g.fillRect((int)x-width/2, (int)y-height/2,  width, height);
	}
	
	
}
