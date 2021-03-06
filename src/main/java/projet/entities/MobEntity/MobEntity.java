package projet.entities.MobEntity;


import projet.entities.Entity;
import projet.game.Handler;
import projet.tiles.Tile;
import projet.entities.EntityManager;
import projet.entities.dynamic.Diamond;
import projet.entities.dynamic.Player;
import projet.game.World;

import java.awt.*;
import java.util.ArrayList;



public class MobEntity extends Entity{

	//public static final int DEFAULT_CREATURE_WIDTH = 64, DEFAULT_CREATURE_HEIGHT = 64;

		public static final float DEFAULT_SPEED = 5.0f;
	    public static final int DEFAULT_CHARACTER_WIDTH = 48;
	    public static final int DEFAULT_CHARACTER_HEIGHT = 48;

	    private int direction;
	    protected float speed;
	    protected float xMove, yMove;
	    public int a = 1;
	    public int b = 2;
	    
	    private EntityManager entityManager;
	    private ArrayList<Entity> entities;
	    public ArrayList<Entity> getEntities() { return entities; }
	    public Entity entity;
	    public Player player;
	    
	    
	 // GETTERS AND SETTERS
	    @Override
	    public boolean isMob(){return true;}
	    
	    public float getDirection() { return direction; }
	    public void setDirection(int direction) { this.direction = direction; }
	    
	    public float getSpeed() { return speed; }
	    public void setSpeed(float speed) { this.speed = speed; }

	    public float getxMove() { return xMove; }
	    public void setxMove(float xMove) { this.xMove = xMove; }

	    public float getyMove() { return yMove; }
	    public void setyMove(float yMove) { this.yMove = yMove; }
	    
		public MobEntity(Handler handler, float x, float y, int width, int height) {
		    super(handler, x, y, width, height);
		    speed = DEFAULT_SPEED;
	        xMove = 0;
	        yMove = 0;
	        direction = 0;
		}


		// METHODS
		
		@Override
		public void die(){
			this.active = false;
			World.entityManager.addEntity(new Diamond(handler, this.getX(), this.getY()));
		}

	    public void move() {
	    	if (direction == 0) { yMove = -speed; if (!checkEntityCollision(0f, yMove)) { moveY(); } else {direction = 1; }}
	        if (direction == 1) { xMove = -speed; if (!checkEntityCollision(xMove, 0f)) { moveX(); } else {direction = 2; }}
	        if (direction == 2) { yMove = speed; if (!checkEntityCollision(0f, yMove)) { moveY(); } else {direction = 3; }}
	        if (direction == 3) { xMove = speed; if (!checkEntityCollision(xMove, 0f)) { moveX(); } else {direction = 0; }}
	        // if((collisionWithTile(tx, (int)(y + bounds.y) / Tile.TILEHEIGHT) && collisionWithTile(tx, (int)(y + bounds.y + bounds.height) / Tile.TILEHEIGHT) || (collisionWithTile((int)(x + bounds.x) / Tile.TILEWIDTH, ty) && collisionWithTile((int)(x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)))) {direction++;if(direction == 4){direction = 0;}}
	    }

	   

		public void moveX() { // t = temp

	        if (xMove < 0) { // Move Left
	            int tx = (int)(x + xMove + bounds.x) / Tile.TILEWIDTH;

	            if(!collisionWithTile(tx, (int)(y + bounds.y) / Tile.TILEHEIGHT) && !collisionWithTile(tx, (int)(y + bounds.y + bounds.height) / Tile.TILEHEIGHT)) {
	                x += xMove;
	            } else {
	            	direction = 2;
	                x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x; // -1 needed or the player is stuck
	            }

	        } else if (xMove > 0 ) { // Move Right
	            int tx = (int)(x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;

	            if(!collisionWithTile(tx, (int)(y + bounds.y) / Tile.TILEHEIGHT) && !collisionWithTile(tx, (int)(y + bounds.y + bounds.height) / Tile.TILEHEIGHT)) {
	                x += xMove;
	            } else {
	                x = tx * Tile.TILEWIDTH - bounds.x - bounds.width - 1; // -1 needed or the player is stuck
	                direction = 0;	                
	            }
	        }
	    }

	    public void moveY() { // Move Up
	        if (yMove < 0) {
	            int ty = (int)(y + yMove + bounds.y)  / Tile.TILEHEIGHT;

	            if(!collisionWithTile((int)(x + bounds.x) / Tile.TILEWIDTH, ty) && !collisionWithTile((int)(x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)) {
	                y += yMove;
	            } else {
	                y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;
	                direction = 1;
	                
	            }

	        } else if (yMove > 0) { // Move Down
	            int ty = (int)(y + yMove + bounds.y + bounds.height)  / Tile.TILEHEIGHT;

	            if(!collisionWithTile((int)(x + bounds.x) / Tile.TILEWIDTH, ty) && !collisionWithTile((int)(x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)) {
	                y += yMove;
	            } else {
	                y = ty * Tile.TILEHEIGHT - bounds.y -bounds.height -1;
	                direction = 3;
	            }
	        }
	    }
	    protected  boolean collisionWithTile(int x, int y) {
	        return handler.getWorld().getTile(x, y).isSolid();

	    }
	    
		@Override
		public void tick() {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void render(Graphics g) {
			// TODO Auto-generated method stub
			
		}
	}

	    	
	    	/*
	    	if(!checkEntityCollision(xMove, 0f)) { // When entity encounter mud or something in moveY, entity move on X
	    		yMove = 0; 
	    		xMove =1 ;
	    		moveX(); 
	    		} 
	        if(!checkEntityCollision(0f, yMove)) { //When entity encounter mud or something in moveX, entity move on Y
	        	xMove = 0; 
	        	yMove = -1;
	        	moveY(); 
	        	} 
	        
	    	}
	    
		
	    
	  
	    	
	    
=======
	    }*/