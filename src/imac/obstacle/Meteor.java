package imac.obstacle;

import com.leapmotion.leap.Vector;

import imac.Space;
import imac.collide.AABB3D;
import processing.core.*;

/**
 * <b>Meteor is the parent class to create geometric obstacles</b>
 * @author Charlie
 * @version 1.0
 */

public class Meteor {
	
	/**
	 * Reference parent PApplet of the app's sketch
	 */
	protected PApplet parent;
	
	/**
	 * Variables used to define the speed of translation and rotation of the obstacle
	 */
	private float speed;
	private float rotate;
	
	/**
	 * Variables used to define the obstacle position
	 */
	private float position_x;
	private float position_y;
	private float position_z;
	AABB3D aabb3d;
	
	/**
	 * Variables used to define the obstacle rotation
	 */
	private float theta_x;
	private float theta_y;
	
	/**
	 * Variables used to define the size of the obstacle
	 */
	private float size;
		
	/* CONSTRUCTORS */
	
	/**
	 * The constructor of Meteor without parameters
	 * 
	 * @since 1.0
	 */
	public Meteor(){}
	
	/**
	 * The constructor of Meteor with 
	 * @param PApplet
	 * 
	 * @since 1.0
	 */	public Meteor(PApplet p){
		this.parent = p;
	}
	
	 /**
	  * The constructor of Meteor with position parameters
	  * @param PApplet
	  * @param x_position
	  * @param y_position
	  * @param z_position
	  * @param speed
	  * @param rotate
	  * @param theta_x
	  * @param theta_y
	  * @param size
	  * 
	  * @since 1.0
	  */
	 public Meteor(PApplet p, float x, float y, float z, float speed, float rotate, float tx, float ty, float s){
		this.parent = p;
		aabb3d = new AABB3D(new Vector(x,y,z), new Vector(s/2.0f, s/2.0f, s/2.0f));
		this.position_x = x;
		this.position_y = y;
		this.position_z = z;
		this.speed = speed;
		this.rotate= rotate;
		this.theta_x = tx;
		this.theta_y = ty;
		this.size = s;
	}
		
	/* GETTERS AND SETTERS */
	
	/**
	 * @return the X position
	 * @since 1.0
	 */
	public float getPositionX(){
		return this.position_x;
		//return this.aabb3d.getCenter().getX();
	}
	
	/**
	 * @return the Y position
	 * @since 1.0
	 */
	public float getPositionY(){
		return this.position_y;
		//return this.aabb3d.getCenter().getY();
	}
	
	/**
	 * @return the Z position
	 * @since 1.0
	 */
	public float getPositionZ(){
		return this.position_z;
		//return this.aabb3d.getCenter().getZ();
	}
	
	/**
	 * @return the position (X, Y, Z)
	 * @since 1.0
	 */
	public Vector getPositionVec(){
		Vector vec = aabb3d.getCenter();
		return vec;
	}
	
	/**
	 * @return the aabb3d
	 */
	public AABB3D getAABB3D() {
		return aabb3d;
	}

	/**
	 * @return the size
	 * @since 1.0
	 */
	public float getSize() {
		return size;
	}
	
	/**
	 * @return the speed
	 * @since 1.0
	 */
	public float getSpeed() {
		return speed;
	}
	
	/**
	 * @return the speed
	 * @since 1.0
	 */
	public float getRotate() {
		return rotate;
	}
	
	/**
	 * @param the x position to set
	 * @param the y position to set
	 * @param the z position to set
	 * @since 1.0
	 */
	public void setPosition(float x, float y, float z){
		this.aabb3d.setCenter(new Vector(x,y,z));
	}
	
	/**
	 * @param the x position to set
	 * @since 1.0
	 */
	public void setPositionX(float x){
		this.position_x = x;
		this.aabb3d.setCenter(new Vector(x, this.aabb3d.getCenter().getY(), this.aabb3d.getCenter().getZ() ));
	}
	
	/**
	 * @param the y position to set
	 * @since 1.0
	 */
	public void setPositionY(float y){
		this.position_y = y;
		this.aabb3d.setCenter(new Vector(this.aabb3d.getCenter().getX(), y, this.aabb3d.getCenter().getZ() ));
	}
	
	/**
	 * @param the z position to set
	 * @since 1.0
	 */
	public void setPositionZ(float z){
		this.position_z = z;
		this.aabb3d.setCenter(new Vector(this.aabb3d.getCenter().getX(), this.aabb3d.getCenter().getY(), z ));
	}
		
	/**
	 * @param the x theta to set
	 * @param the y theta to set
	 * @since 1.0
	 */
	public void setRotation(float theta_x, float theta_y){
		this.theta_x += theta_x;
		this.theta_y += theta_y;
	}
	
	/**
	 * @param the x theta to set
	 * @since 1.0
	 */
	public void setRotationX(float theta){
		this.theta_x += theta;
	}
	
	/**
	 * @param the y theta to set
	 * @since 1.0
	 */
	public void setRotationY(float theta){
		this.theta_y += theta;
	}
	
	/**
	 * @param the size to set
	 * @since 1.0
	 */
	public void setSize(float size) {
		this.size = size;
	}
	
	/**
	 * @param the speed to set
	 * @since 1.0
	 */
	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
	/**
	 * @param the rotation to set
	 * @since 1.0
	 */
	public void setRotate(float theta) {
		this.rotate = theta;
	}
	
	/* OTHER METHODS */
	
	/**
	 * Translate the obstacle on X, Y and Z
	 * @param translate on X
	 * @param translate on Y
	 * @param translate on Z
	 * @since 1.0
	 */
	public void translate(float x, float y, float z){
		this.aabb3d.getCenter().plus(new Vector(x,y,z));
	}
	
	/**
	 * Translate the obstacle on X, Y and Z
	 * @param translate on vector(x,y,z)
	 * @since 1.0
	 */
	public void translate(Vector vec){
		this.aabb3d.getCenter().plus(vec);
	}
	
	/**
	 * Translate the obstacle on X
	 * @param translate on X
	 * @since 1.0
	 */
	public void translateX(float x){
		this.aabb3d.getCenter().plus(new Vector(x, 0.0f, 0.0f));
	}
	
	/**
	 * Translate the obstacle on Y
	 * @param translate on Y
	 * @since 1.0
	 */
	public void translateY(float y){
		this.aabb3d.getCenter().plus(new Vector(0.0f, y, 0.0f));
	}

	/**
	 * Translate the obstacle on Z
	 * @param translate on Z
	 * @since 1.0
	 */
	public void translateZ(float z){
		if(this.position_z > Space.MARGIN_BEHIND_MODEL) this.position_z = Space.METEOR_START;
		else this.position_z += z;
		//this.aabb3d.getCenter().plus(new Vector(0.0f, 0.0f, z));
	}
	
	/**
	 * Display the Meteor on PApplet sketch
	 * @since 1.0
	 */
	public void display(){
		parent.lights();
        parent.pushMatrix();
        parent.translate(this.getPositionX(), this.getPositionY(), this.getPositionZ());
        setRotationX(0.01f);
        translateZ(this.speed);
        parent.rotateX(this.theta_x);
        parent.rotateY(this.theta_y);
        parent.noStroke();
        parent.box(10);
        parent.popMatrix();
	}

}
