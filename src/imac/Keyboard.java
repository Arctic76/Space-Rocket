package imac;

import processing.core.*;

/**
 * <b>Keyboard class is an helper tool to listen keyboard events</b>
 * @author Pierre
 * @version 1.0
 */

public class Keyboard {
	
	/**
	 * Static variables storing the status of
	 * the up, down, left and right keys
	 */
	private static boolean UP, DOWN, LEFT, RIGHT = false;
	
	/**
	 * Static variable referring to graphic displacement
	 */
	private static float MOVE = 1.0f;
	
	/**
	 * Static variable referring to graphic no displacement
	 */
	private static float DONT_MOVE = 0.0f;
	
	/**
	 * Reference parent PApplet of the app's sketch
	 */
	private PApplet parent;
	
	/**
	 * The constructor of Keyboard with PApplet parameter
	 * @param PApplet
	 * 
	 * @since 1.0
	 */
	public Keyboard(PApplet p){
		this.parent = p;
	}
	
	/**
	 * Function called on Engine keyPressed function
	 * Change values of variables UP, DOWN, LEFT and RIGHT
	 * 
	 * @since 1.0
	 */
	public void eventKeyPressed(){
		if (parent.keyCode == PConstants.UP) Keyboard.UP = true;
		if (parent.keyCode == PConstants.DOWN) Keyboard.DOWN = true;
		if (parent.keyCode == PConstants.LEFT) Keyboard.LEFT = true;
		if (parent.keyCode == PConstants.RIGHT) Keyboard.RIGHT = true;
	}
	
	/**
	 * Function called on Engine keyReleased function
	 * Change values of variables UP, DOWN, LEFT and RIGHT
	 * 
	 * @since 1.0
	 */
	public void eventKeyReleased(){
		if (parent.keyCode == PConstants.UP) Keyboard.UP = false;
		if (parent.keyCode == PConstants.DOWN) Keyboard.DOWN = false;
		if (parent.keyCode == PConstants.LEFT) Keyboard.LEFT = false;
		if (parent.keyCode == PConstants.RIGHT) Keyboard.RIGHT = false;
	}
	
	/**
	 * @return x MOVE
	 * @since 1.0
	 */
	public float LeftRightEvent(){
		if(Keyboard.LEFT && Keyboard.RIGHT) return   Keyboard.DONT_MOVE;
		else if(Keyboard.LEFT)              return - Keyboard.MOVE;
		else if(Keyboard.RIGHT)             return   Keyboard.MOVE;
		return Keyboard.DONT_MOVE;
	}
	
	/**
	 * @return y MOVE
	 * @since 1.0
	 */
	public float UpDownEvent(){
		if(Keyboard.UP && Keyboard.DOWN) return   Keyboard.DONT_MOVE;
		else if(Keyboard.UP)             return - Keyboard.MOVE;
		else if(Keyboard.DOWN)           return   Keyboard.MOVE;
		return Keyboard.DONT_MOVE;
	}
}
