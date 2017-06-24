package projet.entities.MobEntity;


import projet.entities.Entity;
import projet.game.Handler;

import java.awt.*;

public class MobEntity extends Entity {

	//public static final int DEFAULT_CREATURE_WIDTH = 64, DEFAULT_CREATURE_HEIGHT = 64;
		public boolean isMob() { return true;}

		public static final float DEFAULT_SPEED = 48;
	    public static final int DEFAULT_CHARACTER_WIDTH = 48;
	    public static final int DEFAULT_CHARACTER_HEIGHT = 48;

	    protected float speed;
	    protected float xMove, yMove;
	    
	 // GETTERS AND SETTERS
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
	        yMove = 1;
		}
		// METHODS
	    public void move() {
	        if (!checkEntityCollision(xMove, 0f)) { xMove++; yMove--; } // When entity encounter mud or something in moveY, entity move on X
	        if (!checkEntityCollision(0f, yMove)) { yMove++; xMove--; } // When entity encounter mud or something in moveX, entity move on Y
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

