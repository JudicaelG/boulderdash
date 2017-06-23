package projet.model.entities;

import projet.model.Handler;
import projet.model.Score;

import java.awt.*;

public abstract class Entity {
// ATTRIBUTES
    protected Handler handler;
    protected float x, y; // position
    protected int width, height; // size
    protected Rectangle bounds;
    protected int health;

    public static final int DEFAULT_HEALTH = 10;
    
    public boolean giveScore(){return false;}		//Whether the entity give score when destroyed. Override this like in diamond.

// ENTITY INTERACTION
    protected boolean active = true;
    
    protected static int diamondCount;
    public static void initDiamondCount(int diamondCount){ Entity.diamondCount = diamondCount;}

    public boolean isActive() {return active;}
    protected boolean solidEntity() { return true; };
    protected boolean breakableEntity() { return false; }
    protected boolean collectableEntity() { return false; }
    public boolean isRock() { return false; }
    public boolean isPlayer() { return false;}
    protected void die() {}
    protected void win() { if (diamondCount <= 0) {System.out.println("YOU WIN !");} }

// GETTERS AND SETTERS
    public float getX() { return x;}
    public void setX(float x) { this.x = x; }

    public float getY() { return y; }
    public void setY(float y) { this.y = y; }

    public int getWidth() { return width; }
    public void setWidth(int width) { this.width = width; }

    public int getHeight() { return height; }
    public void setHeight(int height) { this.height = height; }

    public int getHealth() { return health; }
    
    



    public void hurt(int amt) {
        health -= amt;
        if(health <= 0) {
            active = false;
            die();
        }
    }


// CONSTRUCTOR
    public Entity(Handler handler, float x, float y, int width, int height) {
        this.handler = handler;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        health = DEFAULT_HEALTH;

        bounds = new Rectangle(0, 0, width, height);
    }


// METHODS
    public abstract void tick();
    public abstract void render(Graphics g);


    public boolean checkEntityCollision(float xOffset, float yOffset) {
        for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
            if (e.equals(this) || !e.solidEntity()) { continue; }

            if (e.getCollisionBounds(0f,0f).intersects(getCollisionBounds(xOffset, yOffset)) && e.solidEntity()) {
                if(this.isRock() || this.collectableEntity()) { if (e.isPlayer()) { e.die(); } }
                if ( this.isPlayer() && (e.breakableEntity() || e.collectableEntity())) {
                	e.active = false;
                	// if (e.collectableEntity()) No, isn't mud collectable?
                	if (e.collectableEntity() && e.giveScore() == true){Score.setActScore(Score.getActScore()+10); diamondCount--;System.out.println(Score.getActScore());}		//Works only if there is only diamond giving score. Else we should create a isDiamond bool method or something
                }
                
                return true;
            }
        }
        return false;
    }

    public Rectangle getCollisionBounds(float xOffset, float yOffset) {
        return new Rectangle((int)(x + bounds.x + xOffset), (int)(y + bounds.y + yOffset), bounds.width, bounds.height);
    }
}
