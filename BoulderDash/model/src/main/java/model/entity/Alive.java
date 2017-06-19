package model.entity;

import java.awt.Rectangle;

import model.BoulderDashModel;
import model.Tile.Tile;

public abstract class Alive implements IAlive{

	private static float SPEED = 3;
	public static int WIDTH = 32;
	public static int HEIGHT = 32 ;
	//update 19/06
	protected float xMove, yMove;
	public float DEFAULT_SPEED;
	protected Rectangle bounds;
	private BoulderDashModel boulderDashModel;
	protected float x, y; // position
    protected int width, height; // size
	 
    //Getters and Setters
    public float getX() { return x;}
    public void setX(float x) { this.x = x; }

    public float getY() { return y; }
    public void setY(float y) { this.y = y; }

    public int getWidth() { return width; }
    public void setWidth(int width) { this.width = width; }

    public int getHeight() { return height; }
    public void setHeight(int height) { this.height = height; }
    
    // Constructor
	public Alive(BoulderDashModel boulderDashModel, float x, float y, int width, int height) {
        this.boulderDashModel = boulderDashModel;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        bounds = new Rectangle(0, 0, width, height);
	}
	public void MoveX () { // t = temp
        if (xMove < 0) { // Move Left
            int tx = (int)(x + xMove + bounds.x) / Tile.TILEWIDTH;

            if(!collisionWithTile(tx, (int)(y + bounds.y) / Tile.TILEHEIGHT) && !collisionWithTile(tx, (int)(y + bounds.y + bounds.height) / Tile.TILEHEIGHT)) {
                x += xMove;
            } else {
                x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x; // -1 needed or the player is stuck

            }

        } else if (xMove > 0 ) { // Move Right
            int tx = (int)(x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;

            if(!collisionWithTile(tx, (int)(y + bounds.y) / Tile.TILEHEIGHT) && !collisionWithTile(tx, (int)(y + bounds.y + bounds.height) / Tile.TILEHEIGHT)) {
                x += xMove;
            } else {
                x = tx * Tile.TILEWIDTH - bounds.x - bounds.width - 1; // -1 needed or the player is stuck
            }
        }
    }
	public void MoveY () { // Move Up
        if (yMove < 0) {
            int ty = (int)(y + yMove + bounds.y)  / Tile.TILEHEIGHT;

            if(!collisionWithTile((int)(x + bounds.x) / Tile.TILEWIDTH, ty) && !collisionWithTile((int)(x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)) {
                y += yMove;
            } else {
                y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;
            }

        } else if (yMove > 0) { // Move Down
            int ty = (int)(y + yMove + bounds.y + bounds.height)  / Tile.TILEHEIGHT;

            if(!collisionWithTile((int)(x + bounds.x) / Tile.TILEWIDTH, ty) && !collisionWithTile((int)(x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)) {
                y += yMove;
            } else {
                y = ty * Tile.TILEHEIGHT - bounds.y - bounds.height - 1;
            }
        }
	}
	protected  boolean collisionWithTile(int x, int y) {
        return BoulderDashModel.getWorld().getTile(x, y).isSolid();
    }
	/*public void die(){
		Move as an other class
	}*/
	/*public Direction getDirection(){
		return null;
		delett
	}*/
	/*public void setDirection(Direction direction){
		delet to
	}*/
}rtgdrtd
