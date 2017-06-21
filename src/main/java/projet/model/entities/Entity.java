package projet.model.entities;

import projet.model.Handler;

import java.awt.*;

public abstract class Entity {
// ATTRIBUTES
    protected Handler handler;
    protected float x, y; // position
    protected int width, height; // size
    protected Rectangle bounds;

// ENTITY INTERACTION
    protected boolean active = true;

    public boolean isActive() {return active;}
    protected boolean solidEntity() { return true; };
    protected boolean breakableEntity() { return false; }
    protected boolean collectableEntity() { return false; }
    protected boolean testEntity() { return false; }


// GETTERS AND SETTERS
    public float getX() { return x;}
    public void setX(float x) { this.x = x; }

    public float getY() { return y; }
    public void setY(float y) { this.y = y; }

    public int getWidth() { return width; }
    public void setWidth(int width) { this.width = width; }

    public int getHeight() { return height; }
    public void setHeight(int height) { this.height = height; }


// CONSTRUCTOR
    public Entity(Handler handler, float x, float y, int width, int height) {
        this.handler = handler;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        bounds = new Rectangle(0, 0, width, height);
    }


// METHODS
    public abstract void tick();
    public abstract void render(Graphics g);


    public boolean checkEntityCollision(float xOffset, float yOffset) {
        for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
            if (e.equals(this) || !e.solidEntity()) { continue; }

            if (e.getCollisionBounds(0f,0f).intersects(getCollisionBounds(xOffset, yOffset)) && e.solidEntity()) {
                if (e.breakableEntity() || e.collectableEntity()) { e.active = false; }
                if (e.testEntity()) {  }
                return true;
            }
        }
        return false;
    }

    public Rectangle getCollisionBounds(float xOffset, float yOffset) {
        return new Rectangle((int)(x + bounds.x + xOffset), (int)(y + bounds.y + yOffset), bounds.width, bounds.height);
    }
}
