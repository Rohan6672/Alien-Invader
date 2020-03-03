package jrJava.alienInvader;

import resources.DrawingBoard;

public class TorpedoManager {

	private static int maxNumber = 10; // length of the array.
	private static int size;  // number of live torpedoes.
	
	private static Torpedo[] torpedoes;
	
	
	static {
		torpedoes = new Torpedo[maxNumber];
	}
	
	
	public static void draw(DrawingBoard board){
		for(int i=0; i<size; i++){
			torpedoes[i].draw(board);
		}
	}
	
	
	public static void move(){
		
		// walk backward.
		for(int i=size-1; i>=0; i--){
			torpedoes[i].move();
			if(torpedoes[i].getY()<0){
				remove(i);
			}
		}
		
		/*
		// walk forward.
		for(int i=0; i<size; i++){
			torpedoes[i].move();
			if(torpedoes[i].getY()<0){
				remove(i);
				i--; // rewind the index
			}
		}
		*/
		
	}
	
	
	public static void add(Torpedo torpedo){
		if(size==maxNumber) return;
		torpedoes[size] = torpedo;
		size++;
	}
	
	
	public static void remove(int index){
		for(int i=index+1; i<size; i++){
			torpedoes[i-1] = torpedoes[i];
		}
		torpedoes[size-1] = null;
		size--;
	}
	
	
	public static void remove(Torpedo torpedo){
		for(int i=0; i<size; i++){
			if(torpedoes[i]==torpedo){
				remove(i);
				return;
			}
		}
	}
	
}
















