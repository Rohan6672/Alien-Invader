package jrJava.alienInvader;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import resources.DrawingBoard;


public class Ship implements MouseListener, MouseMotionListener, KeyListener {

	private int x, y; // center, top
	private static int topWidth = 4;
	private static int middleWidth = 20;
	private static int bottomWidth = 60;
	private static int height = 20;
	private Color color = Color.red;
	private int lastX;
	
	
	
	public Ship(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	
	public boolean isHit(Missile missile){
		int eX = missile.getX();
		int eY = missile.getY();
		int eW = Missile.getWidth();
		int eH = Missile.getHeight();
		
		return isHit(eX ,eY, eW, eH);
	}
	
	
	public boolean isHit(Alien alien){
		int eX = alien.getX();
		int eY = alien.getY();
		int eW = Alien.WIDTH;
		int eH = Alien.HEIGHT;
		
		return isHit(eX ,eY, eW, eH);
	}
	
	
	private boolean isHit(int eX, int eY, int eW, int eH){
		if(eX>=x-topWidth/2-eW/2 && eX<=x+topWidth/2+eW/2 && eY>=y && eY<=y+height+eH ||
		   eX>=x-middleWidth/2-eW/2 && eX<=x+middleWidth/2+eW/2 && eY>=y+height && eY<=y+2*height+eH  ||
		   eX>=x-bottomWidth/2-eW/2 && eX<=x+bottomWidth/2+eW/2 && eY>=y+2*height && eY<=y+3*height+eH){
				return true;
			}
			return false;
	}
	
	
	public void draw(DrawingBoard board){
		Graphics2D canvas = board.getCanvas();
		canvas.setColor(color);
		canvas.drawRect(x-topWidth/2, y, topWidth, height);
		canvas.drawRect(x-middleWidth/2, y+height, middleWidth, height);
		canvas.drawRect(x-bottomWidth/2, y+2*height, bottomWidth, height); 
	}

	
	public void mousePressed(MouseEvent e) {
		//System.out.println("Pressed");
		lastX = e.getX();
	}

	public void mouseDragged(MouseEvent e) {
		int mx = e.getX();
		int dx = mx - lastX;
		x += dx;
		
		//System.out.println("dragged ship's x=" + x); 
		lastX = mx;
	}
	
	
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if(keyCode==KeyEvent.VK_SPACE){
			 TorpedoManager.add( new Torpedo(x, y-12, -7) );
		}
	}
	
	
	
	public void mouseMoved(MouseEvent e) {} 
	public void mouseClicked(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void keyTyped(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
	
}










