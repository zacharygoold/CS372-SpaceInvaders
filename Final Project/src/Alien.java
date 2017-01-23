import java.awt.*;

public class Alien {
	public static int width = 20, height = 20;
	public static double speedX = 40, speedY = 20, bulletSpeed = .0025; //how fast the alien moves
	private double x, y, maxX, maxY, dx, dy, bullet; //position, max position, and speed
	
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
	
	public void update(double d){
		x+=dx*d;
		y+=dy*d;
		if(x > maxX || x < 0){
			wall();
		}
	}
	
	public void wall(){
		if (x > maxX){
			x = maxX;
		} 
		if (x < 0){
			x = 0;
		}

	}
	
	
	public void draw(Graphics g){
		g.setColor(Color.RED);
		g.fillRect((int)x-width/2, (int)y-height/2,  width, height);
	}
	
	
}
