package imac;

import processing.core.*;
import java.util.ArrayList;
import imac.obstacle.*;

/**
 * <b>Space class contains all meteor obstacle.</b>
 * <p>It generates random position for each meteor</p>
 * <p>It use Perlin Noise<p>
 * @author Pierre
 * @author Charlie
 * @version 1.0
 */

public class Space {
	
	/**
	 * Reference parent PApplet of the app's sketch
	 */
	private PApplet parent;
	
	/**
	 * Collection with all meteors
	 */
	private ArrayList<Meteor> meteors;
	
	/**
	 * Number of meteors
	 */
	int nbMeteors;
	
	/**
	 * When a meteor begins to be visible 
	 */
	private static float METEOR_START = -1200.0f;
	
	/**
	 * When a meteor is not visible anymore
	 */
	private static float MARGIN_BEHIND_MODEL = 100.0f;
	
	/**
	 * When a meteor is not visible anymore
	 */
	private static float FILL_GRID = 227;
	
	/**
	 * Space constructor
	 * It initialize the meteors ArrayList with Perlin Noise
	 * 
	 * @param PApplet
	 * @param meteors number
	 * 
	 * @since 1.0
	 */
	Space(PApplet p, int nbMeteors, float minSpeed, float maxSpeed){
		this.parent = p;
		this.meteors = new ArrayList<Meteor>();
		this.nbMeteors = nbMeteors;
		
		float yoff = 0.0f;
		float xoff = 0.0f;

		float zoff = parent.random(METEOR_START + 100.0f, Space.METEOR_START);;
		
		for(int i=0; i< this.nbMeteors; i++){
			
			float y = PApplet.map(parent.noise(xoff, yoff), 0, 1, 0, Engine.WINDOW_HEIGHT);
			float speed = parent.random(minSpeed, maxSpeed);
			int randShape = (int)parent.random(1, 3);
			
			if(randShape == 1)       this.meteors.add(new Box(this.parent, xoff, y, zoff, speed, parent.random(10, 15)));
			else if( randShape == 2) this.meteors.add(new Sphere(this.parent, xoff, y, zoff, speed, parent.random(10, 15)));
			
			xoff += 10;
		    yoff += 4;
		}
	}
	
	/**
	 * Space gird
	 * 
	 * @param PApplet
	 * @param meteors number
	 * 
	 * @since 1.0
	 */
	private void drawGrid(){
		parent.stroke(Space.FILL_GRID);
		int gridSize = 40;
		int xoffset = Engine.WINDOW_WIDTH/2;
		int yoffset = 250;
		int zoffset = -300;
	    for(int i = -Engine.WINDOW_WIDTH/2; i <Engine.WINDOW_WIDTH; i+=gridSize) {
	    for(int j = -Engine.WINDOW_HEIGHT/2; j < Engine.WINDOW_HEIGHT; j+=gridSize) {
	      int y = 200;
	      parent.line(xoffset + i,          yoffset + y, zoffset + j,           xoffset + i+gridSize, yoffset + y, zoffset + j          );
	      parent.line(xoffset + i+gridSize, yoffset + y, zoffset + j,           xoffset + i+gridSize, yoffset + y, zoffset + j+gridSize );
	      parent.line(xoffset + i+gridSize, yoffset + y, zoffset + j+gridSize,  xoffset + i,          yoffset + y, zoffset + j+gridSize );
	      parent.line(xoffset + i,          yoffset + y, zoffset + j,           xoffset + i,          yoffset + y, zoffset + j+gridSize );
	    }
	  }
	}
	
	/**
	 * @return METEOR_START
	 * @since 1.0
	 */
	public static float getMeteorStart(){
		return Space.METEOR_START;
	};
	
	/**
	 * @return MARGIN_BEHIND_MODEL
	 * @since 1.0
	 */
	public static float getMarginBehindModel(){
		return Space.MARGIN_BEHIND_MODEL;
	};
	/**
	 * Display the space constructor
	 * 
	 * @since 1.0
	 */
	public void display(){
		drawGrid();
		for(int i = 0; i < this.meteors.size(); i++)
	    {	
			meteors.get(i).display();
		}
	}
	
}
