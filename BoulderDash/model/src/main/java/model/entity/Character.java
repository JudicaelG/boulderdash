package model.entity;

import projet.model.Handler;
import projet.model.entities.Entity;
import projet.model.Tile;

public abstract class Character extends Entity {
// ATTRIBUTES
    public static final float DEFAULT_SPEED = 24;
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


// CONSTRUCTOR
    public Character(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
        speed = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;
    }


// METHODS
    public void move() {
        if (!checkEntityCollision(xMove, 0f)) { moveX(); }
        if (!checkEntityCollision(0f, yMove)) { moveY(); }
    }

    public void moveX() { // t = temp
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

    public void moveY() { // Move Up
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
                y = ty * Tile.TILEHEIGHT - bounds.y -bounds.height -1;
            }
        }
    }

    protected  boolean collisionWithTile(int x, int y) {
        return handler.getWorld().getTile(x, y).isSolid();
    }
}
