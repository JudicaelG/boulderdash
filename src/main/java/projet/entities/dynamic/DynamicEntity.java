package projet.entities.dynamic;

import projet.entities.Entity;
import projet.game.Handler;
import projet.tiles.Tile;

public abstract class DynamicEntity extends Entity {
// ATTRIBUTES
/**
 * The default speed of dynamic entities
 */
    public static final float DEFAULT_SPEED = 5.0f;

/**
 * The default width of dynamic entities (same as tile width)
 */
    public static final int DEFAULT_CHARACTER_WIDTH = 48;

/**
 * The default height of dynamic entities (same as tile height)
 */
    public static final int DEFAULT_CHARACTER_HEIGHT = 48;

    protected float speed;

/**
 * The amount of pixels an entity has to move
 */
    protected float xMove, yMove;


// GETTERS AND SETTERS
    public float getSpeed() { return speed; }
    public void setSpeed(float speed) { this.speed = speed; }

    public float getxMove() { return xMove; }
    public void setxMove(float xMove) { this.xMove = xMove; }

    public float getyMove() { return yMove; }
    public void setyMove(float yMove) { this.yMove = yMove; }


// CONSTRUCTOR
    public DynamicEntity(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
        speed = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;
    }


// METHODS
/**
 * Moves the player by checking positions
 */
    public void move() {
        if (!checkEntityCollision(xMove, 0f)) { moveX(); }
        if (!checkEntityCollision(0f, yMove)) { moveY(); }
    }


/**
 * Detects collisions and determines if the entity can move further or not on the x axis
 */
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


/**
 * Detects collisions and determines if the entity can move further or not on the y axis
 */
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


    /**
     * Checks collision by checking if a tile is solid or not
     *
     * @param x The x position of the entity
     * @param y The y position of the entity
     *
     * @return Every solid projet.tiles
     */
    protected  boolean collisionWithTile(int x, int y) {
        return handler.getWorld().getTile(x, y).isSolid();
    }
}
