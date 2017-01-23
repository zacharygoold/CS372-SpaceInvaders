import javax.swing.JApplet;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;


public class SpaceInvaders extends JApplet implements Runnable, KeyListener{ //use applet because it is a simple UI design
	
	public static void main(String[] args){
		
	}
	
	private Player player;
	private boolean left, right; //going left or right
	
	@Override
	public void init(){
		addKeyListener(this); //same class as keyboard input
		
		player = new Player(getWidth()/2, getHeight()-Player.height/2, getWidth()); //sets up player
		
		
		new Thread(this).start(); //allows to run while it is running
	}
	@Override
	public void paint(Graphics graphics){
		BufferedImage background = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_4BYTE_ABGR); //setting up background as bufferedImage
		Graphics g = background.getGraphics();
		g.setColor(Color.BLACK); //sets color as black
		g.fillRect(0, 0, getWidth(), getHeight()); // fills entire screen
		
		player.draw(g); //draws the player
		
		graphics.drawImage(background, 0, 0, null); //draws the image
	}
	@Override 
	public void keyPressed(KeyEvent k){
		//switch statement to see if player is going left or right when pressed
		switch(k.getKeyCode()){
		case KeyEvent.VK_LEFT: left = true; break;
		case KeyEvent.VK_RIGHT: right = true; break; 
		}
		
		
		
		if (k.getKeyCode() == KeyEvent.VK_LEFT) {
			left = true; 
		}
		if (k.getKeyCode() == KeyEvent.VK_RIGHT){
			right = true; 
		}
	}
	@Override
	public void keyReleased(KeyEvent k){
		switch(k.getKeyCode()){
		case KeyEvent.VK_LEFT: left = false; break;
		case KeyEvent.VK_RIGHT: right = false; break; 
		}
		
		
		
		/*if (k.getKeyCode() == KeyEvent.VK_LEFT) {
			left = false; 
		}
		if (k.getKeyCode() == KeyEvent.VK_RIGHT){
			right = false; 
		}*/
	}
	@Override
	public void keyTyped(KeyEvent k){
		
	}
	
	public void update(double d){ //seconds
		if(left)
			player.moveLeft(d);
		if(right)
			player.moveRight(d);
		/*if(left == true){
			player.moveLeft(d);
		}
		if(right == true){
			player.moveRight(d);
		}*/
	}
	
	@Override
	public void run(){ //our runnable
		long time = System.nanoTime();
		while(true){ //always runs
			try{
				Thread.sleep(50);
			}	catch(Throwable t){;}
			double d = (System.nanoTime() - time) * 1E-9;
			time = System.nanoTime();
			update(d); //updates the time
			
			repaint(); //repaints the stuff on the screen
		}
	}
	
}
