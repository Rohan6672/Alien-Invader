package jrJava.alienInvaderWithImages_polymorphism;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

import resources.DrawingBoard;

public class Missile {

	public static final int WIDTH, HEIGHT;
	
	private int x, y; // center, bottom
	private int vy; // vy>0
	private static Image image;
	private boolean collided;
	private static Color explosionColor;
	private static int explosionRadius;
	
	
	static {
		image = new ImageIcon(Coordinator.RESOURCE_PATH + "missile.png").getImage();
		WIDTH = image.getWidth(null);
		HEIGHT = image.getHeight(null);
		
		explosionColor = Color.green;
		explosionRadius = 70;
	}


	public Missile(int x, int y, int vy){
		this.x = x;
		this.y = y;
		this.vy = vy;
	}


	public int getX(){ return x; }
	public int getY(){ return y; }
	public static int getWidth(){ return WIDTH; }
	public static int getHeight(){ return HEIGHT; }
	
	
	public boolean isHit(Torpedo torpedo){
		if(torpedo.getX()>x-WIDTH/2-Torpedo.getWidth()/2 &&
				torpedo.getX()<x+WIDTH/2+Torpedo.getWidth()/2 &&	
				torpedo.getY()>y-HEIGHT-Torpedo.getHeight() &&
				torpedo.getY()<y){

			MissileManager.remove(this); 
			return true;
		}

		return false;
	}


	public void move(Ship ship){
		y += vy;
		
		if(ship.isHit(this)){
			collided = true;
			
		}
	}


	public void draw(DrawingBoard board){
		Graphics2D canvas = board.getCanvas();
		
		if(collided){
			canvas.setColor(explosionColor);
			canvas.fillOval(x-explosionRadius, y-explosionRadius, 2*explosionRadius, 2*explosionRadius);
			Coordinator.gameOver = true;
		}
		else {
			canvas.drawImage(image, x-WIDTH/2, y-HEIGHT, null);
		}
	}

}












