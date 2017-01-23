import javax.swing.JApplet;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.Vector;

/**
 * SpaceInvaders models the creation of the JApplet and draws and creates everything inside of it
 * Here you make x amount of invaders, one ship, randomly firing bullets, and ship firing bullets
 * @author zgoold17
 *
 */

@SuppressWarnings("serial")
public class SpaceInvaders extends JApplet implements Runnable, KeyListener{ //used an JApplet because I was going to try and put it on a webpage
	
	public static void main(String[] args){
		
	}
	
	private Player player;
	private boolean left, right; //going left or right
	private Vector<Alien> aliens; //the aliens
	private Vector<Bullet> bullets; //the bullets
	
	/**
	 * Initialize the keyboard, set up the player, aliens, ect, tell it to run
	 */
	@Override
	public void init(){
		addKeyListener(this); //same class as keyboard input
		setFocusable(true);
		player = new Player(getWidth()/2, getHeight()-Player.height/2, getWidth()); //sets up player
		bullets = new Vector<Bullet>(); //our bullets
		
		aliens = new Vector<Alien>();
		for (int i = 0; i <5; i++){
			Alien newAlien = new Alien(Alien.width*(2*i+2), Alien.height*(2*i+2), getWidth(), false);
			aliens.add(newAlien);
		}
		
		new Thread(this).start(); //allows to run while it is running
	}
	/**
	 * This is where paint is overrided to draw the background, player, aliens, ect
	 */
	@Override
	public void paint(Graphics graphics){
		BufferedImage background = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_4BYTE_ABGR); //setting up background as bufferedImage
		Graphics g = background.getGraphics();
		g.setColor(Color.BLACK); //sets color as black
		g.fillRect(0, 0, getWidth(), getHeight()); // fills entire screen
		
		player.draw(g); //draws the player
		for(int i =0; i < aliens.size(); i++){ //draws the aliens
			aliens.get(i).draw(g);
		}
		for(int i = 0; i < bullets.size(); i++){ //draws the bullets
			bullets.get(i).draw(g);
		}
		graphics.drawImage(background, 0, 0, null); //draws the image
	}
	/**
	 * If the key is pressed the ship will move left and right!
	 */
	@Override 
	public void keyPressed(KeyEvent k){
		//statement to see if player is going left or right when pressed
		if (k.getKeyCode() == KeyEvent.VK_LEFT) {
			left = true; 
		}
		if (k.getKeyCode() == KeyEvent.VK_RIGHT){
			right = true; 
		}
	}
	/**
	 * If the key is released we don't want the ship to move anymore
	 */
	@Override
	public void keyReleased(KeyEvent k){
		if (k.getKeyCode() == KeyEvent.VK_LEFT) {
			left = false; 
		}
		if (k.getKeyCode() == KeyEvent.VK_RIGHT){
			right = false; 
		}
	}
	
	@Override
	public void keyTyped(KeyEvent k){
		//add when space is pressed to shoot
	}
	/**
	 * This is where the infinite loop is, also where time is kept and repaints
	 * This makes it so all computers runs the program at the same speed as well
	 */
	@Override
	public void run(){ //our runnable
		long time = System.nanoTime();
		while(true){ //always runs
			try{
				Thread.sleep(50);
			}catch(Exception e){System.out.println("Ut Oh.");}
			double d = (System.nanoTime() - time) * 1E-9;
			time = System.nanoTime();
			update(d); //updates the time
			
			repaint(); //repaints the stuff on the screen
		}
	}
	/**
	 * The update function for moving aliens and player when TRUE
	 * @param d
	 */
	public void update(double d){ //seconds
		if(left == true){
			player.moveLeft(d);
		}
		if(right == true){
			player.moveRight(d);
		}
		for(int i =0; i < aliens.size(); i++){
			aliens.get(i).update(d);
		}
	}
	
}
